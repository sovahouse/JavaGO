$(function () {
    if (localStorage.getItem("StoreToEdit") !== null) {
        update();
    }
});

function update() {
    var store = getData();
    var li = document.createElement('li');
    li.innerHTML = 'Name: ' + store.ingredient.name;
    $('.first').before(li);

    $('#quantity').val(store.quantity);

    $('#editform').submit(function (e) {
        e.preventDefault();
        var quantity = $('#quantity').val();

        if ($.isNumeric(quantity)) {
            store.quantity = quantity;
        } else {
            console.error("invalid input"); //TODO: вывод ошибки на екран
        }


        upload(store);
    });
}

function upload(data) {
    $.ajax({
        url: "/admin/store/update",
        type: "POST",
        data: JSON.stringify(data),
        contentType: "application/json",
        dataType: "json",
        complete: function () {
            $('.success').toggle();
        }
    });
}

function getData() {
    return $.ajax({
        async:false,
        url: '/admin/store/id=' + localStorage.getItem("StoreToEdit"),
        type:'get',
        dataType: 'JSON'
    }).responseJSON;
}
