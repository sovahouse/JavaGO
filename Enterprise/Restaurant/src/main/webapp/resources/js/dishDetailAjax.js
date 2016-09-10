$(function () {
    $.ajax({
        url: '/dishes/id=' + localStorage.getItem("dishIdForDishDetail"),
        dataType: 'json',
        success: function (data) {
            console.log('data', data);
            var menu = document.querySelector('.menu');
            var figure = document.createElement('figure');
            var inner =  data.name + '<figcaption>' + '<img src="' + data.photo + '">' + '</figcaption>';
            figure.innerHTML += inner;
            menu.appendChild(figure);
            // localStorage.removeItem("dishIdForDishDetail");

        }
    });
});
