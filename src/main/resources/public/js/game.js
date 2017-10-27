$(function() {
  $('#game .box').click(function(){

    var val = this.getAttribute('data-value');

    $.ajax({
      url: '/get/' + val,
      type: 'GET',
      success: function(result) {

        if (result == "false") {

          $.ajax({
            url: '/' + val,
            type: 'PUT',
            success: function(result) {

              $("[data-value=" + val + "]").children("div").text(result);

                $.ajax({
                  url: '/check/',
                  type: 'GET',
                  success: function(result) {

                    if (result == "x") {

                      $("#game").toggleClass("win").text("Winner is X!");

                    } else if (result == "O") {

                      $("#game").toggleClass("win").text("Winner is O!");

                    } else if (result == "draw") {

                      $("#game").toggleClass("win").text("Draw!");
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