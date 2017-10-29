$(document).ready(function() {

  var gameId;

  updateScore();

  function updateScore() {

    $.ajax({
      url: "/scoreboard/",
      type: "GET",
      success: function(result) {

        var scoreboard = $.parseJSON(result);

        if (scoreboard.length != 0) {

          $("#scoreBoard tbody").empty()

          for (var i = 0; i < scoreboard.length; i++) {

            $("#scoreBoard tbody").append("<tr><th scope=\"row\" class=\"rownumber\">" + (i + 1) +"</th><td>" + scoreboard[i].name + "</td><td>" + scoreboard[i].wins + "</td><td>" + scoreboard[i].losses + "</td></tr>");
          }
        }
      }
    });
  }

  function quitGame() {

    $.ajax({
      url: "/stop/" + gameId,
      type: "PUT",
      success: function(result) {}
    });
  }

  $("#start").on("submit", function(e){

    if ("gameId" in window) {

      quitGame();
    }

    var formData = $("#start").serializeArray();

    $.ajax({
      url: "/start/" + formData[0].value + "/" + formData[1].value,
      type: "POST",
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
                    updateScore();

                  } else if (result == "o") {

                    $("#game").addClass("win").text("Winner is O!");
                    quitGame();
                    updateScore();

                  } else if (result == "draw") {

                    $("#game").toggleClass("win").text("Draw!");
                    quitGame();
                    updateScore();
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
