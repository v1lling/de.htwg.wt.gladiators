/**
* Ends turn and sets new current player
 */
function onClickEndTurn() {
    var fnSuccess = function(result) {
        console.log(result);
        // set active player
    }
    sendRequest("/gladiators/end", fnSuccess);
}

/**
 * Loads the controller as json
 * Initializes the game
 */
function loadJson() {
    var fnSuccess = function(result) {
        console.log(result);
        // initializing
    }
    sendRequest("/json", fnSuccess);
}

/**
 * Sends a request to the server
 * @param {string} path - The request URL
 * @param {function} fnSuccess - Callback function for success
 */
function sendRequest(path, fnSuccess) {
    $.ajax({
        method: "GET",
        url: path,
        dataType: "json",
        success: function (result) {
            fnSuccess(result);
        },
        error: function(result) {
            console.log(result);
        }
    });
}

$(document).ready(function() {
    console.log("Document is ready, filling grid");
    loadJson();
});