$(function () {
    $('#editform').submit(function (e) {
        e.preventDefault();
        var store = {};
        var ingredient = {};
        var name = $('#name').val();
        var quantity = $('#quantity').val();

        if(isNameValid(name)) {
            ingredient.name = name;
            store.ingredient = ingredient;
        } else {
            $('.errorName').toggle();
            throw new Error("invalid name input");
        }

        if(isQuantityValid(quantity)) {
            store.quantity = quantity;
        } else {
            $('.errorQuantity').toggle();
            throw new Error("invalid quantity input");
        }
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

function isNameValid(name) {
    var result = true;
    if(!isAlpha(name)) {
        result = false;
    }
    return result;
}
function isQuantityValid(quantity) {
    var result = true;
    if(!(Math.floor(quantity) == quantity && $.isNumeric(quantity))) {
        result = false;
    }
    return result;
}


function isAlpha(s) {
    return s.match("^[a-zA-Z]");
}
