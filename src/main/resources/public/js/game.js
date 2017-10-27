$(function() {
  $('#game .box').click(function(){

    var val = this.getAttribute('data-value');

    $.ajax({
      url: '/' + val,
      type: 'PUT',
      success: function(result) {
          $("[data-value=" + val + "]").children("div").text(result);
      }
    });
  });
});