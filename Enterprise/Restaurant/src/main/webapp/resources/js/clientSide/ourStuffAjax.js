$(function () {
    $.ajax({
        url: '/employees',
        dataType: 'json',
        success: function (data) {
            var stuff = document.querySelector('.stuff');
            $.each(data, function (i, val) {
                if (val.position === "WAITER") {
                    var figure = document.createElement('figure');
                    $(figure).addClass("figure");
                    figure.innerHTML += '<figcaption>' + '<img src="' + val.photo + '">' +
                        '</figcaption>' + val.name;
                    stuff.appendChild(figure);
                }
            });
        }
    });
});