$(function () {
    localStorage.clear();
    var data = getData();
    generateItems(data);
    $('.submit').click(function (e) {
        e.preventDefault();
        var result = [];
        var name = $('#name').val();
        for(var i = 0; i < data.length; i++) {
            if(data[i].ingredient.name.toLowerCase().indexOf(name.toLowerCase()) >= 0) {
                result.push(data[i]);
            }
        }

        deleteItems();
        generateItems(result);
    });

    $('.delete').click(function (e) {
        e.preventDefault();
        var id = $(this).attr("name");
        $('#myModal').modal();
        $('.btn-agree').on('click', function () {
            var result = {};
            for (var i = 0; i < data.length; i++) {
                if (data[i].id == id) {
                    result = data[i];
                    break;
                }
            }
            deleteStore(result);
            location.reload();
        });


    });

    $('.edit').click(function () {
        var id = $(this).attr("name");
        localStorage.setItem("StoreToEdit", id);
    });
});

function generateItems(data) {
    var wrapper = document.querySelector('.wrapper');

    $.each(data, function (i, store) {

        var container = document.createElement('div');
        $(container).addClass("container");
        container.innerHTML += '<p> Name: ' + store.ingredient.name + '</p>' +
            '<p> Quantity: ' + store.quantity + '</p>' +
            '<p>' + '<a href="/admin/store/edit">' + '<button class="edit" name="' + store.id + '">' + 'Edit' + '</button>' + '</a>' +
            '<button class="delete"  name="' + store.id + '">' + 'Delete' + '</button>' + '</p>';
        wrapper.appendChild(container);
    });
}

function deleteItems() {
    $('.wrapper').empty();
}

function deleteStore(store) {
    $.ajax({
        url: "/admin/store/delete",
        type: "POST",
        data: JSON.stringify(store),
        contentType: "application/json",
        dataType: "json"
    });
}

function getData() {
    return $.ajax({
        async: false,
        url: '/admin/getAllStore',
        type: 'get',
        dataType: 'JSON'
    }).responseJSON;
}
