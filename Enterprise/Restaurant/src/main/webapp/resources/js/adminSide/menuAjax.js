$(function () {
    localStorage.clear();
    var data = getData();
    var wrapper = document.querySelector('.wrapper');

    $.each(data, function (i, menu) {

        var container = document.createElement('div');
        $(container).addClass("container");
        container.innerHTML += '<p class="name">' + menu.name + '</p>' +
            '<p>' + '<a href="/admin/menu/edit">' + '<button class="edit" name="' + menu.id + '">' + 'Edit' + '</button>' + '</a>' +
            '<button class="delete"  name="' + menu.id + '">' + 'Delete' + '</button>' + '</p>';
        wrapper.appendChild(container);
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
        deleteMenu(result);
        location.reload();
    });
    $('.edit').click(function () {
        var id = $(this).attr("name");
        localStorage.setItem("MenuToEdit", id);
    });
});

function deleteMenu(menu) {
    $.ajax({
        url: "/admin/menu/delete",
        type: "POST",
        data: JSON.stringify(menu),
        contentType: "application/json",
        dataType: "json"
    });
}

function getData() {
    return $.ajax({
        async: false,
        url: '/admin/getAllMenu',
        type: 'get',
        dataType: 'JSON'
    }).responseJSON;
}