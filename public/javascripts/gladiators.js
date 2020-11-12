/**
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
            fnSuccess(oResult);
        },
        error: function(oResult) {
            console.log(oResult);
        }
    });
}

$(document).ready(function() {
    console.log("Document is ready, filling grid");
    loadJson();
});