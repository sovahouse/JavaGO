$(function () {
    if (localStorage.getItem("StoreToEdit") !== null) {
        update();
    } else {
        create();
    }
});

function update() {
    var store = getData();
    var wrapper = document.querySelector('.wrapper');
    wrapper.innerHTML = '<p>name: ' + store.ingredient.name + '</p>' + wrapper.innerHTML;

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
        url: "/store/createOrUpdate",
        type: "POST",
        data: JSON.stringify(data),
        contentType: "application/json",
        dataType: "json"
    });
}

function getData() {
    return $.ajax({
        async:false,
        url: '/store/id=' + localStorage.getItem("StoreToEdit"),
        type:'get',
        dataType: 'JSON'
    }).responseJSON;
}
