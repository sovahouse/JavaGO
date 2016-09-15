$(function () {
    localStorage.clear();
    var data = getData();

    var wrapper = document.querySelector('.wrapper');

    $.each(data, function (i, dish) {

        var figure = document.createElement('figure');
        $(figure).addClass("figure");
        figure.innerHTML += '<figcaption>' + '<img src="' + dish.photo + '">' + '</figcaption>' +
            dish.name + ' ' + dish.weight + 'g' + '<p>';

        $.each(dish.ingredients, function (i, ingredient) {
            if (i + 1 !== dish.ingredients.length) {
                figure.innerHTML += ingredient.name + ', ';
            } else {
                figure.innerHTML += ingredient.name;
            }
        });

        figure.innerHTML += '</p>' + dish.price + ' UAH' + '</a>' +
            '<p>' + '<a href="/admin/dish/edit">' + '<button class="edit" name="' + dish.id + '">' + 'Edit' + '</button>' + '</a>' +
            '<button class="delete"  name="' + dish.id + '">' + 'Delete' + '</button>' + '</p>';
        wrapper.appendChild(figure);
    });

    $('.delete').click(function () {
        var id = $(this).attr("name");
        var result = {};
        for (var i = 0; i < data.length; i++) {
            if (data[i].id == id) {
                result = data[i];
                break;
            }
        }
        upload(result);
        location.reload();

    });
});



function upload(data) {
    $.ajax({
        url: "/dishes/delete",
        type: "POST",
        data: JSON.stringify(data),
        contentType: "application/json",
        dataType: "json"
    });
}

function getData() {
    return $.ajax({
        async: false,
        url: '/dishes',
        type: 'get',
        dataType: 'JSON'
    }).responseJSON;
}