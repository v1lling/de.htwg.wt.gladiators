var oController = {},
    oCurrGladiator = {};

/**
 * Event when tile is clicked
 */
function onClickTile(oSource) {
    var x = oSource.getAttribute("x"),
        y = oSource.getAttribute("y"),
        sPath = "";
    console.log("Tile clicked: " + x + "," + y);
    toggleActiveClass(oSource.children[0]);
    if (oCurrGladiator.shop) {
        //buy
        sPath = "/gladiators/buy "+(oCurrGladiator.shopIndex+1)+" "+x+" "+y;
        oCurrGladiator = {}; //FIXME: only when success
        sendRequest(sPath);
    } else if(oCurrGladiator.board) {
        //move or attack
        sPath = "/gladiators/move "+oCurrGladiator.x+" "+oCurrGladiator.y+" "+x+" "+y;
        oCurrGladiator = {}; //FIXME: only when success
        sendRequest(sPath);
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
    var fnSuccess = function(oResult) {
        console.log(oResult);
        // set active player
    }
    sendRequest("/gladiators/end", fnSuccess);
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
 * Updates the gladiator
 */
function updateGladiators() {
    if (oController) {
        $(".board-tile").removeClass (function (index, className) {
            return (className.match (/(^|\s)glad-\S+/g) || []).join(' ');
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
 * Updates the shop
 */
function updateShop() {
    if (oController) {
        $(".shop-item").removeClass (function (index, className) {
            return (className.match (/(^|\s)glad-\S+/g) || []).join(' ');
        });
        //FIXME for some reason this is not working yet
        oController.shop.stock.forEach(function(g, i) {
            $(".shop-item").filter("[index="+i+"]")
            .data("gladiator", g)
            .addClass("glad-" + g.type)
            .html(g.calculateCost)
        });
    }
}

/**
 * Loads the controller as json
 * Initializes the game
 */
function loadJson() {
    var fnSuccess = function(oResult) {
        console.log(oResult);
        // initializing
    }
    sendRequest("/json", fnSuccess);
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
            //save Json
            oController = oResult;
            if (fnSuccess) {
                fnSuccess(oResult);
            }
            //FIXME: not always call this, put this into fnSuccess callback
            updateGladiators(); 
            updateShop();
        }.bind(this),
        error: function(oResult) {
            console.log(oResult);
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

$(document).ready(function() {
    console.log("Document is ready, filling grid");
    loadJson();
});