var oController = {},
    oCurrGladiator = {};

/**
 * Event when tile is clicked
 */
function onClickTile(oSource) {
    var x = oSource.getAttribute("x"),
        y = oSource.getAttribute("y"),
        sPath = "";
    toggleActiveClass(oSource.children[0]);
    if (oCurrGladiator.shop) {
        //buy
        sPath = "/gladiators/buy "+(parseInt(oCurrGladiator.shopIndex)+1)+" "+x+" "+y;
        sendRequest(sPath, function() {
            updateGame();
            oCurrGladiator = {};
        });
    } else if(oCurrGladiator.board) {
        //move or attack
        sPath = "/gladiators/move "+oCurrGladiator.x+" "+oCurrGladiator.y+" "+x+" "+y;
        sendRequest(sPath, function() {
            updateBoard();
            oCurrGladiator = {};
        });
    } else {
        //save gladiator
        oCurrGladiator = {};
        if ($(oSource).data("gladiator")) {
            //save
            oCurrGladiator = {
                board: true,
                x: x,
                y: y
            }
        }
    }
}

/**
 * Event when gladiator in shop is clicked
 */
function onClickShopItem(oSource) {
    oCurrGladiator = {
        shop: true,
        shopIndex: oSource.getAttribute("index")
    };
    toggleActiveClass();
}

/**
 * Event when "End Turn" button is clicked
 * Ends turn and sets new current player
 */
function onClickEndTurn() {
    sendRequest("/gladiators/end", updateCurrentPlayer);
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
            .addClass("glad-" + g.type);
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
                $(".board-tile").filter("[x="+x+"]").filter("[y="+y+"]")
                    .addClass("tile-" + tile.type)
            })
        });
        oController.playerOne.gladiators.forEach(function(g) {
            var x = g.position.x,
                y = g.position.y,
                type = g.type;
            $(".board-tile").filter("[x="+x+"]").filter("[y="+y+"]")
            .data("gladiator", g)
            .addClass("glad-"+type+"1");
        });
        oController.playerTwo.gladiators.forEach(function(g) {
            var x = g.position.x,
                y = g.position.y,
                type = g.type;
            $(".board-tile").filter("[x="+x+"]").filter("[y="+y+"]")
                .data("gladiator", g)
                .addClass("glad-"+type+"2");
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
 * Sends a request to the server
 * @param {string} sPath - The request URL
 * @param {function} fnSuccess - Callback function for success
 */
function sendRequest(sPath, fnSuccess) {
    $.ajax({
        method: "GET",
        url: sPath,
        dataType: "json",
        success: function (oResult) {
            oController = oResult;
            if (fnSuccess) {
                fnSuccess();
            }
        }.bind(this),
        error: function(oResponse) {
            Msg.error(oResponse.responseText, 5000);
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

$(document).ready(function() {
    console.log("Document is ready, loading data");
    sendRequest("/json", updateGame);
});