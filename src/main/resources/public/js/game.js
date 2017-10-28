$(document).ready(function() {

  var gameId;

  function quitGame() {

    $.ajax({
      url: "/stop/" + gameId,
      type: "PUT",
      success: function(result) {}
    });
  }

  $("#start").click(function(e){

    if ("gameId" in window) {

      quitGame();
    }

    $.ajax({
      url: "/start/",
      type: "PUT",
      success: function(result) {

        gameId = result;

        $("#game").removeClass("win");
      }
    });

    e.preventDefault();
  });

  $(window).on("unload", function() {

    quitGame();
  });

  $('#game .box').click(function(){

    var val = this.getAttribute('data-value');

    $.ajax({
      url: "/id/" + gameId + "/get/" + val,
      type: "GET",
      success: function(result) {

        if (result == "false") {

          $.ajax({
            url: "/id/" + gameId + "/pos/" + val,
            type: "PUT",
            success: function(result) {

              $("[data-value=" + val + "]").children("div").text(result);

              $.ajax({
                url: "/check/" + gameId,
                type: "GET",
                success: function(result) {

                  if (result == "x") {

                    $("#game").toggleClass("win").text("Winner is X!");
                    quitGame();

                  } else if (result == "O") {

                    $("#game").addClass("win").text("Winner is O!");
                    quitGame();

                  } else if (result == "draw") {

                    $("#game").toggleClass("win").text("Draw!");
                    quitGame();
                  }
                }
              });
            }
          });
        }
      }
    });
  });
});