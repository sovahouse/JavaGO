$(function () {
    $('#editform').submit(function (e) {
        e.preventDefault();
        var store = {};
        var ingredient = {};
        var name = $('#name').val();
        var quantity = $('#quantity').val();


        ingredient.name = name;
        store.ingredient = ingredient;
        store.quantity = quantity;
        console.log(store);
        upload(store);
    });
});

function upload(data) {
    $.ajax({
        url: "/admin/store/create",
        type: "POST",
        data: JSON.stringify(data),
        contentType: "application/json",
        dataType: "json",
        complete: function () {
            $('.success').toggle();
        }
    });
}