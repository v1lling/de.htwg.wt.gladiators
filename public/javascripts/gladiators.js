var oController = {},
    oCurrGladiator = {};

/**
 * Event when tile is clicked
 * @param {Object} oSource - source element of click
 */
function onClickTile(oSource) {
    var x = oSource.getAttribute("x"),
        y = oSource.getAttribute("y");
    toggleActiveClass(oSource.children[0]);
    if (oCurrGladiator.source === "shop") {
        //buy
        sendBuyRequest(parseInt(oCurrGladiator.shopIndex)+1, parseInt(x), parseInt(y), function(oEvent) {
            updateGame();
            var iNewCredits1 = oController.playerOne.credits,
                iNewCredits2 = oController.playerTwo.credits;
            animateValue("idPlayer1Credits", iNewCredits1, 1000);
            animateValue("idPlayer2Credits", iNewCredits2, 1000);
        });
        oCurrGladiator = {};
    } else if(oCurrGladiator.source === "board") {
        //move or attack
        sendMoveRequest(parseInt(oCurrGladiator.x), parseInt(oCurrGladiator.y), parseInt(x), parseInt(y), updateBoard);
        oCurrGladiator = {};
    } else {
        //save gladiator
        oCurrGladiator = {};
        if ($(oSource).data("gladiator")) {
            oCurrGladiator = {
                source: "board",
                x: x,
                y: y
            }
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
    sendRequest("POST", "/gladiators/api/command", {"commandType": "EndTurn"}, updateCurrentPlayer);
}

/**
 * Shows the stats of a gladiator
 * @param {object} oGladiator - the Gladiator
 */
function showGladiatorStats(oSource) {
    var oGladiator = $(oSource).data("gladiator");
    if (oGladiator) {
        $("#idGladiatorAP").html(oGladiator.attackPoints);
        $("#idGladiatorHP").html(oGladiator.healthPoints);
        $("#idGladiatorMP").html(oGladiator.movementPoints);
    } else {
        $("#idGladiatorAP").html("-");
        $("#idGladiatorHP").html("-");
        $("#idGladiatorMP").html("-");
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
        removePrefixClass("shop-item","glad");
        oController.shop.stock.forEach(function(g, i) {
            $(".shop-item").filter("[index="+i+"]")
            .data("gladiator", g)
            .addClass("glad-" + g.gladiatorType);
            // .children("span").text("???") //FIXME: we need the cost as an attribute of gladiator
        });
    }
}

/**
 * Updates the board (tiles + gladiators)
 */
function updateBoard() {
    if (oController) {
        removePrefixClass("board-tile","tile");
        removePrefixClass("board-tile", "glad");
        oController.board.tiles.forEach(function(row, y) {
            row.forEach(function(tile, x) {
                if (tile.tileType == "Base") {
                    if (y == 0) {
                        tile.tileType += "1";
                    } else {
                        tile.tileType += "2";
                    }
                }
                $(".board-tile").filter("[x="+x+"]").filter("[y="+y+"]")
                    .addClass("tile-" + tile.tileType)
            })
        });
        oController.playerOne.gladiators.forEach(function(g) {
            var x = g.position.x,
                y = g.position.y;
            $(".board-tile").filter("[x="+x+"]").filter("[y="+y+"]")
            .data("gladiator", g)
            .addClass("glad-"+g.gladiatorType+"1");
        });
        oController.playerTwo.gladiators.forEach(function(g) {
            var x = g.position.x,
                y = g.position.y;
            $(".board-tile").filter("[x="+x+"]").filter("[y="+y+"]")
                .data("gladiator", g)
                .addClass("glad-"+g.gladiatorType+"2");
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
 * Sends a buy request to the server
 * @param {int} iIndex - The request URL
 * @param {int} iX - x-value of position
 * @param {int} iY - y-value of position
 * @param {function} fnSuccess - Success callback function
 */
function sendBuyRequest(iIndex, iX, iY, fnSuccess) {
    var oPayload = {
            "commandType" : "BuyUnit",
            "number": iIndex,
            "position": {"x" : iX, "y": iY}
        };
    sendRequest("POST", "/gladiators/api/command", oPayload, fnSuccess);
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
   var oPayload = {
        "commandType" : "Move",
        "from": {"x" : iX, "y": iY},
        "to": {"x" : iNewX, "y": iNewY}
    };
   sendRequest("POST", "/gladiators/api/command", oPayload, fnSuccess);
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
        }
    });
}

/**
 * Sets the active class for an element
 * Removes active class from the rest
 * @param {Object} oElement - the new active element
 */
function toggleActiveClass(oElement) {
    $(".overlay").removeClass("active");
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
        var element = $(this)[0];
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
    var iStart = parseInt(document.getElementById(sId).innerHTML);
    if (iStart === iNewValue) return;
    var range = iNewValue - iStart;
    var current = iStart;
    var increment = iNewValue > iStart? 1 : -1;
    var stepTime = Math.abs(Math.floor(iDuration / range));
    var obj = document.getElementById(sId);
    var timer = setInterval(function() {
        current += increment;
        obj.innerHTML = current;
        if (current == iNewValue) {
            clearInterval(timer);
        }
    }, stepTime);
}

$(document).ready(function() {
    console.log("Document is ready, loading data");
    sendRequest("GET", "/json", {}, updateGame);
});