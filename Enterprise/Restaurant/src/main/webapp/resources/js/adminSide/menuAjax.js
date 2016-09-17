$(function () {
    localStorage.clear();
    var data = getData();
    var wrapper = document.querySelector('.wrapper');

    $.each(data, function (i, menu) {

        var container = document.createElement('div');
        $(container).addClass("container");
        container.innerHTML += '<p class="name">' + menu.name + '</p>' +
            '<p>' + '<a href="/admin/menu/edit">' + '<button class="edit" name="' + menu.name + '">' + 'Edit' + '</button>' + '</a>' +
            '<button class="delete"  name="' + menu.name + '">' + 'Delete' + '</button>' + '</p>';
        wrapper.appendChild(container);
    });
    $('.delete').click(function () {
        var name = $(this).attr("name");
        var result = {};
        for (var i = 0; i < data.length; i++) {
            if (data[i].name === name) {
                result = data[i];
                break;
            }
        }
        deleteMenu(result);
        location.reload();

    });
});

function deleteMenu(menu) {
    $.ajax({
        url: "/menu/delete",
        type: "POST",
        data: JSON.stringify(menu),
        contentType: "application/json",
        dataType: "json"
    });
}

function getData() {
    return $.ajax({
        async: false,
        url: '/menu',
        type: 'get',
        dataType: 'JSON'
    }).responseJSON;
}