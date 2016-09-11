$(function () {
    $.ajax({
        url: '/dishes/id=' + localStorage.getItem("dishIdForDishDetail"),
        dataType: 'json',
        success: function (data) {
            console.log('data', data);
            var menu = document.querySelector('.menu');
            var figure = document.createElement('figure');
            $(figure).addClass("figure");
            figure.innerHTML += '<figcaption>' + '<img src="' + data.photo + '">' + '</figcaption>' +
                data.name + ' ' + data.weight + 'g' + '<p>';
            $.each(data.ingredients, function (i, val) {
                if(i + 1 !== data.ingredients.length) {
                    figure.innerHTML += val.name + ', ';
                } else {
                    figure.innerHTML += val.name;
                }
            });
            figure.innerHTML += '</p>' + data.price + ' UAH' + '</a>';
            menu.appendChild(figure);
        }
    });
});
