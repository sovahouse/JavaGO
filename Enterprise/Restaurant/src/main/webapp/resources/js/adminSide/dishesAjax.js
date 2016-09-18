$(function () {
    localStorage.clear();
    var data = getData();

    var wrapper = document.querySelector('.wrapper');

    $.each(data, function (i, dish) {

        var container = document.createElement('div');
        $(container).addClass("container");
        var figure = document.createElement('figure');

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
        container.appendChild(figure);
        wrapper.appendChild(container);
    });
    $('.edit').click(function () {
        var id = $(this).attr("name");
        localStorage.setItem("DishToEdit", id);
    });

    $('.delete').click(function (e) {
        e.preventDefault();

        $('#myModal').modal();
        $('.btn-agree').on('click', function () {
            var id = $('.delete').attr("name");
            var result = {};
            for (var i = 0; i < data.length; i++) {
                if (data[i].id == id) {
                    result = data[i];
                    break;
                }
            }
            deleteDish(result);
            location.reload();
        });

    });
});


function deleteDish(dish) {
    $.ajax({
        url: "/admin/dishes/delete",
        type: "POST",
        data: JSON.stringify(dish),
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