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
    toggleActive(oSource.children[0]);
    if (oCurrGladiator.shop) {
        //buy
        sPath = "/gladiators/buy "+oCurrGladiator.shopIndex+" "+x+" "+y;
        oCurrGladiator = {}; //TODO: only when success
        sendRequest(sPath);
    } else if(oCurrGladiator.board) {
        //move or attack
        sPath = "/gladiators/move "+oCurrGladiator.x+" "+oCurrGladiator.y+" "+x+" "+y;
        oCurrGladiator = {}; //TODO: only when success
        sendRequest(sPath);
    } else {
        //save gladiator
        oCurrGladiator = {};
        if (oSource.getAttribute("gladiator")) {
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
    toggleActive();
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
            oController = oResult.response;
            if (fnSuccess) {
                fnSuccess(oResult);
            }
        },
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
function toggleActive(oElement) {
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