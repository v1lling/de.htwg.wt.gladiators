$(document).ready(function() {
    console.log("Document is ready, loading data");
    connectWebSocket();
    sendRequest("GET", "/json", {}, function() {
        if (oController.gameState == "NamingPlayerOne") {
            $("#idModal").data("player", "One");
            openModal("Player 1", "Enter name", "player-one");
        } else if(oController.gameState =="NamingPlayerTwo") {
            $("#idModal").data("player", "Two");
            openModal("Player 2", "Enter name", "player-two");
        }
        updateGame();
    });
});

// Global variables
var oController = {},
    oCurrGladiator = {};

var websocket = new WebSocket("ws://localhost:9000/websocket");

/**
 * Event when tile is clicked
 * @param {Object} oSource - source element of click
 */
function onClickTile(oSource) {
    let x = oSource.getAttribute("x"),
        y = oSource.getAttribute("y");
    if (oCurrGladiator.source === "shop") {
        //buy
        sendBuyRequest(parseInt(oCurrGladiator.shopIndex)+1, parseInt(x), parseInt(y));
    } else if(oCurrGladiator.source === "board") {
        //move
        sendMoveRequest(oCurrGladiator.x, oCurrGladiator.y, parseInt(x), parseInt(y));
    } else {
        resetCurrGladiator();
    }
}

/**
 * Event when gladiator is clicked
 * @param {Object} e - click event
 */
function onClickGladiator(e) {
    e.stopPropagation();
    let oClickedGladiator = $(e.target).data("gladiator");
    if(oCurrGladiator.source === "board") {
        //attack
        sendMoveRequest(oCurrGladiator.x, oCurrGladiator.y, oClickedGladiator.position.x, oClickedGladiator.position.y);
    } else {
        if (oClickedGladiator.moved === false && 
            ((JSON.stringify(oController.currentPlayer) === JSON.stringify(oController.playerOne) && $(e.target).hasClass("glad-player1"))
            || (JSON.stringify(oController.currentPlayer) === JSON.stringify(oController.playerTwo) && $(e.target).hasClass("glad-player2")))) {

            // save gladiator in cache
            toggleActiveClass(e.target);
            sendRequest("POST","/gladiators/api/gladiatorSelect", {"x": oClickedGladiator.position.x, "y": oClickedGladiator.position.y}, function(oResult) {
                highlightMoveTiles(oResult.tilesMove);
                highlightAttackTiles(oResult.tilesAttack);
            });
            oCurrGladiator = { 
                source: "board",
                x: oClickedGladiator.position.x,
                y: oClickedGladiator.position.y
            }
        } else {
            // invalid
            animateGladiatorShake($(e.target));
        }
    }
}

/**
 * Event when gladiator in shop is clicked
 * @param {Object} oSource - source element of click
 */
function onClickShopItem(oSource) {
    oCurrGladiator = {
        source: "shop",
        shopIndex: oSource.getAttribute("index")
    };
    toggleActiveClass();
}

/**
 * Event when "End Turn" button is clicked
 * Ends turn and sets new current player
 */
function onClickEndTurn() {
    //sendRequest("POST", "/gladiators/api/command", {"commandType": "EndTurn"}, updateGame);
    websocket.send(JSON.stringify({"commandType": "EndTurn"}));
}

/**
 * Event when "OK" button of modal is clicked
 */
function onSubmitModal() {
    let oModal = $("#idModal"),
        oPayload = {
            "commandType" : "NamePlayer" + oModal.data("player"),
            "name": $("#idModalInput").val()
        };
    websocket.send(JSON.stringify(oPayload));
}

/**
 * Highlights the tiles where a Gladiator can move
 * @param {Arry} aTiles - list of tiles 
 */
function highlightMoveTiles(aTiles) {
    if (aTiles && aTiles.length) {
        aTiles.forEach(function(oTile) {
            $("#idTileX"+oTile.x+"Y"+oTile.y).addClass("move-range");
        });
    }  
}

/**
 * Highlights the tiles where a Gladiator can attack
 * @param {Arry} aTiles - list of tiles 
 */
function highlightAttackTiles(aTiles) {
    if (aTiles && aTiles.length) {
        aTiles.forEach(function(oTile) {
            $("#idTileX"+oTile.x+"Y"+oTile.y).addClass("attack-range");
        });
    }  
}

/**
 * Shows the stats of a gladiator
 * @param {object} oGladiator - the Gladiator
 */
function showGladiatorStats(oSource) {
    let oGladiator = $(oSource.target).data("gladiator");
    removePrefixClass("gladiatorinfo-image","glad-");
    if (oGladiator) {
        $("#idGladiatorAP").html(oGladiator.attackPoints);
        $("#idGladiatorHP").html(oGladiator.healthPoints);
        $("#idGladiatorMP").html(oGladiator.movementPoints);
        $(".gladiatorinfo-image").addClass("glad-"+oGladiator.gladiatorType);
    } else {
        $("#idGladiatorAP").html("-");
        $("#idGladiatorHP").html("-");
        $("#idGladiatorMP").html("-");
    }
}

/**
 * Resets the currently selected gladiator
 */
function resetCurrGladiator() {
    oCurrGladiator = {};
    toggleActiveClass();
    $(".board-tile").removeClass("move-range").removeClass("attack-range");;
}

/**
 * Updates player information panel
 */
function updatePlayers() {
    if (oController) {
        if (oController.playerOne) {
            $("#idPlayer1Name").html(oController.playerOne.name);
            $("#idPlayer1Health").html(oController.playerOne.health);
            $("#idPlayer1Credits").html(oController.playerOne.credits);
        }
        if (oController.playerTwo) {
            $("#idPlayer2Name").html(oController.playerTwo.name);
            $("#idPlayer2Health").html(oController.playerTwo.health);
            $("#idPlayer2Credits").html(oController.playerTwo.credits);
        }
    }
}

/**
 * Updates the current player
 */
function updateCurrentPlayer() {
    if (oController) {
        $(".playerinfo").removeClass("active");
        if (JSON.stringify(oController.currentPlayer) === JSON.stringify(oController.playerOne)) {
            $(".player1").addClass("active");
        } else {
            $(".player2").addClass("active");
        }
    }
}

/**
 * Updates the shop
 */
function updateShop() {
    if (oController) {
        removePrefixClass("shop-item","glad-");
        oController.shop.stock.forEach(function(g, i) {
            $(".shop-item").filter("[index="+i+"]")
            .data("gladiator", g)
            .addClass("glad-" + g.gladiatorType)
            .children("span").text("$" + g.cost);
        });
    }
}

/**
 * Updates the board (tiles + gladiators)
 */
function updateBoard() {
    if (oController) {
        removePrefixClass("board-tile","tile-");
        $(".gladiatorcontainer").remove();
        oController.board.tiles.forEach(function(row, y) {
            row.forEach(function(tile, x) {
                if (tile.tileType == "Base") {
                    y == 0 ? tile.tileType += "1": tile.tileType += "2";
                }
                $("#idTileX"+x+"Y"+y).addClass("tile-" + tile.tileType)
            })
        });
        oController.playerOne.gladiators.forEach(function(g) {
            createGladiatorDiv(g, 1);
        });
        oController.playerTwo.gladiators.forEach(function(g) {
            createGladiatorDiv(g, 2);
        });
    }
}

/**
 * Updates the game
 */
function updateGame() {
    updateShop();
    updateBoard();
    updateCurrentPlayer();
}


/**
 * Creates a div of gladiator and places it in DOM
 * @param {Object} oGladiator - gladiator
 * @param {int} iPlayer - player 
 */
function createGladiatorDiv(oGladiator, iPlayer) {
    let x = oGladiator.position.x,
        y = oGladiator.position.y,
        parent = $("#idTileX"+x+"Y"+y);
    let element = $('<div/>',{}).data("gladiator", oGladiator)
        .attr('class','gladiator glad-'+oGladiator.gladiatorType+' glad-player' + iPlayer)
        .click(onClickGladiator)
        .mouseover(showGladiatorStats)
        .css("height", parent.height() * 0.8)
        .css("width", parent.width());
    let healthbar = $('<div/>',{})
        .attr('class','healthbar');
    let healthbarinside = $('<div/>',{})
        .attr('class','healthbar-inside')
        .appendTo(healthbar);
    let container = $('<div/>',{})
        .attr("class", "gladiatorcontainer")
        .attr("id", "idGladX" + x + "Y" + y);
    element.appendTo(container);
    healthbar.appendTo(container);
    updateHealthBar(container);
    container.appendTo(parent);
}

/**
 * Updates the healthbar of a gladiator
 * @param {Object} oGladiatorContainerDiv - div that contains gladiator and healthbar
 * @param {boolean} bKilled - boolean value if gladiator is killed 
 */
function updateHealthBar(oGladiatorContainerDiv, bKilled) {
    if (!bKilled) {
        let oGladiator = oGladiatorContainerDiv.find(".gladiator").data("gladiator"),
            iPercentage = oGladiator.healthPoints / oGladiator.initialHealthPoints * 100;
        oGladiatorContainerDiv.find(".healthbar-inside").css("width", iPercentage+"%");
        oGladiatorContainerDiv.find(".healthbar-inside").css("background", perc2color(iPercentage));
    } else {
        oGladiatorContainerDiv.find(".healthbar-inside").css("width", 0);
        oGladiatorContainerDiv.find(".healthbar-inside").css("background", perc2color(0));
    }
}

/**
 * Returns a color for a percentage between green and red
 * https://gist.github.com/mlocati/7210513
 * @param {int} iPercentage - percentage
 */
function perc2color(iPercentage) {
	let r, g, b = 0;
	if(iPercentage < 50) {
		r = 255;
		g = Math.round(5.1 * iPercentage);
	}
	else {
		g = 255;
		r = Math.round(510 - 5.10 * iPercentage);
	}
	let h = r * 0x10000 + g * 0x100 + b * 0x1;
	return '#' + ('000000' + h.toString(16)).slice(-6);
}

/**
 * Sets the active class for an element
 * Removes active class from the rest
 * @param {Object} oElement - the new active element
 */
function toggleActiveClass(oElement) {
    $(".gladiator").removeClass("active");
    $(".shop-item").removeClass("active");
    if (oElement) {
        $(oElement).addClass("active");
    }
}

/**
 * Removes a class from elements
 * @param {String} sElementClass - class of elements
 * @param {String} sRemoveClass - prefix of to be removed class
 */
function removePrefixClass(sElementClass, sRemoveClass) {
    $("."+sElementClass).each(function() {
        let element = $(this)[0];
        const classes = element.className.split(" ").filter(c => !c.startsWith(sRemoveClass));
        element.className = classes.join(" ").trim();
    });
}

/**
 * Animates the change of an integer value
 * @param {String} sId - id of element
 * @param {Integer} iNewValue - new value
 * @param {Integer} iDuration - duration time of animation in ms
 */
function animateValue(sId, iNewValue, iDuration) {
    let iStart = parseInt(document.getElementById(sId).innerHTML);
    if (iStart === iNewValue) return;
    let range = iNewValue - iStart;
    let current = iStart;
    let increment = iNewValue > iStart? 1 : -1;
    let stepTime = Math.abs(Math.floor(iDuration / range));
    let obj = document.getElementById(sId);
    let timer = setInterval(function() {
        current += increment;
        obj.innerHTML = current;
        if (current == iNewValue) {
            clearInterval(timer);
        }
    }, stepTime);
}

/**
 * Animates the movement of an element
 * @param {String} oMoveElement - Element to be moved
 * @param {Integer} oNewParent - new parent element
 * @param {Integer} iDuration - duration time of animation in ms
 */
function animateGladiatorMove(oMoveElement, oNewParent, iDuration) {
    let newEle = oMoveElement.clone(true).appendTo(oNewParent),
        newPos = newEle.position();
    newEle.hide();
    oMoveElement.find(".healthbar").hide();
    oMoveElement.css('position', 'absolute').animate(newPos, iDuration, function() {
        newEle.show();
        oMoveElement.remove();
    });
    return newEle;
};

/**
 * Shows attack animation of gladiator
 * @param {Object} oGladiatorContainerDiv - div that contains gladiator and healthbar
 */
function animateGladiatorAttacked(oGladiatorContainerDiv) {
    let oGladiatorDiv = oGladiatorContainerDiv.find(".gladiator");
    oGladiatorDiv.addClass("attacked");
    setTimeout(function() {
        oGladiatorDiv.removeClass("attacked");
    }, 1000)
}

/**
 * Animates a shake of a gladiator
 * @param {Object} oGladiatorDiv - gladiator element
 */
function animateGladiatorShake(oGladiatorDiv) {
    oGladiatorDiv.addClass("shake");
    setTimeout(function() {
        oGladiatorDiv.removeClass("shake");
    },1000);
}

/**
 * Opens the modal
 * @param {String} sHeader - header label
 * @param {String} sInputLabel - input label
 * @param {String} sClass - class for modal
 */
function openModal(sHeader, sInputLabel, sClass) {
    removePrefixClass("modal","player-");

    $("#idModalHeader").text(sHeader);
    $("#idInputLabel").text(sInputLabel);
    $("#idModal").addClass(sClass).modal();
}


/**
 * Sends a buy request to the server
 * @param {int} iIndex - The request URL
 * @param {int} iX - x-value of position
 * @param {int} iY - y-value of position
 * @param {function} fnSuccess - Success callback function
 */
function sendBuyRequest(iIndex, iX, iY, fnSuccess) {
    let oPayload = {
            "commandType" : "BuyUnit",
            "number": iIndex,
            "position": {"x" : iX, "y": iY}
        };
    websocket.send(JSON.stringify(oPayload));
    //sendRequest("POST", "/gladiators/api/command", oPayload, fnSuccess);
}

/**
* Sends a move request to the server
* @param {int} iX - x-value of initial position
* @param {int} iY - y-value of initial position
* @param {int} iNewX - x-value of new position
* @param {int} iNewY - y-value of new position
* @param {function} fnSuccess - Success callback function
*/
function sendMoveRequest(iX, iY, iNewX, iNewY, fnSuccess) {
   let oPayload = {
        "commandType" : "Move",
        "from": {"x" : iX, "y": iY},
        "to": {"x" : iNewX, "y": iNewY}
    };
    websocket.send(JSON.stringify(oPayload));
    //sendRequest("POST", "/gladiators/api/command", oPayload, fnSuccess);
}


/**
 * Sends a request to the server
 * @param {string} sMethod - The method of the HTTP request
 * @param {string} sPath - The request URL
 * @param {object} oPayload - The request body dada
 * @param {function} fnSuccess - Callback function for success
 */
function sendRequest(sMethod, sPath, oPayload, fnSuccess) {
    $.ajax({
        method: sMethod,
        url: sPath,
        data: JSON.stringify(oPayload),
        dataType: "json",
        contentType: "application/json",
        success: function (oResult) {
            oController = oResult[0];
            if (fnSuccess) {
                fnSuccess(oResult[1]);
            }
        }.bind(this),
        error: function(oResponse) {
            Msg.error(oResponse.responseJSON.message, 2000);
        },
        complete: function() {
            resetCurrGladiator();
        }
    });
}

/**
 * Initializes a websocket
 */
function connectWebSocket() {
    console.log("Connecting to Websocket");
    console.log("Connected to Websocket");

    websocket.onopen = function(event) {
        console.log("Trying to connect to Server");
    }

    websocket.onclose = function () {
        console.log('Connection Closed!');
    };

    websocket.onerror = function (error) {
        console.log('Error Occured: ' + error);
    };

    websocket.onmessage = function (e) {
        let oResponse = JSON.parse(e.data);

        oController = oResponse[0];
        let oEvent = oResponse[1];

        resetCurrGladiator();
        
        switch(oEvent.eventType) {
            case "PlayerOneNamed":
            case "PlayerTwoNamed":
                updatePlayers();
                $("#idModal").modal("hide");
            case "Turn":
                updateCurrentPlayer();
                break;
            case "SuccessfullyBoughtGladiator":
                updateGame();
                if (JSON.stringify(oEvent.player) === JSON.stringify(oController.playerOne)) {
                    animateValue("idPlayer1Credits", oEvent.player.credits, 1000);
                } else {
                    animateValue("idPlayer2Credits", oEvent.player.credits, 1000);
                }
                break;
            case "Moved":
                let oCurrGladiator = $("#idGladX" + oEvent.from.x + "Y" + oEvent.from.y).attr("id", "#idGladX" + oEvent.to.x + "Y" + oEvent.to.y)
                animateGladiatorMove(oCurrGladiator, $("#idTileX"+oEvent.to.x+"Y"+oEvent.to.y), 1500); // remove curr gladiator
                break;
            case "Mined":
                updateBoard();
                break;
            case "BaseAttacked":
            case "Won":
                if (JSON.stringify(oEvent.currentPlayer) === JSON.stringify(oController.playerTwo)) {
                    animateValue("idPlayer1Health", oController.playerOne.health, 1000);
                } else {
                    animateValue("idPlayer2Health", oController.playerTwo.health, 1000);
                }
            case "Attacked":
                let bFound = false,
                    oToGladiator = $("#idGladX" + oEvent.to.x + "Y" + oEvent.to.y);

                animateGladiatorAttacked(oToGladiator);
                //TODO: give back attacked gladiator in event from backend
                oToGladiator.data("gladiator", )
                oController.playerOne.gladiators.concat(oController.playerTwo.gladiators).forEach(function(gladiator) {
                    if (JSON.stringify(gladiator.position) == JSON.stringify(oEvent.to)) {
                        $("#idTileX"+gladiator.position.x+"Y"+gladiator.position.y).find(".gladiator").data("gladiator", gladiator);
                        updateHealthBar(oToGladiator);
                        bFound = true;
                    }
                });
                //TODO: oEvent.killed not working yet              
                if (!bFound) {
                    updateHealthBar(oToGladiator, true);
                    setTimeout(function() {oToGladiator.remove()}, 1000); 
                }
        }
    }.bind(this);
}