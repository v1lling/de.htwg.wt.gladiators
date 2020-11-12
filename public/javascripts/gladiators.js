
function loadJson() {
    $.ajax({
        method: "GET",
        url: "/json",
        dataType: "json",

        success: function (result) {
            console.log(result);
            /*
            grid = new Grid(result.grid.size);
            grid.fill(result.grid.cells);
            updateGrid(grid);
            registerClickListener();
            */
        }
    });
}

$(document).ready(function() {
    console.log("Document is ready, filling grid");
    loadJson();
});