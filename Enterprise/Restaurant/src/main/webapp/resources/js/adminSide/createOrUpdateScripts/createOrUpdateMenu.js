$(function () {
    if (localStorage.getItem("MenuToEdit") !== null) {
        update();
    } else {
        create();
    }
});

$(function () {
    $('.dishesList').on('click', '#add',  function () {
        addDishesDOM();
    });
    $('.dishesList').on('click', '#remove',  function () {
        removeDishesDOM();
    });
});

function addDishesDOM() {
    $('#add').remove();
    $('#remove').remove();

    var dishNumber = $('.dishesList').children().length;
    var data = getDishes();

    var li = document.createElement('li');
    var label = document.createElement('label');
    var select = document.createElement('select');
    var addButton = document.createElement('button');
    var removeButton = document.createElement('button');
    select.setAttribute('name', 'dishes');
    select.setAttribute('id', dishNumber + 1);
    label.setAttribute('for', 'dishes');
    addButton.setAttribute('id', 'add');
    addButton.setAttribute('type', 'button');
    removeButton.setAttribute('id', 'remove');
    removeButton.setAttribute('type', 'button');

    label.innerHTML = 'Dish '+ (dishNumber + 1) +':';
    addButton.innerHTML = 'Add another';
    removeButton.innerHTML = 'Remove';

    for (var i = 0; i < data.length; i++) {
        var option = document.createElement('option');
        option.setAttribute('value', data[i].name);
        option.setAttribute('id', data[i].name);
        option.innerHTML = data[i].name;
        select.appendChild(option);
    }
    li.appendChild(label);
    li.appendChild(select);
    li.appendChild(addButton);
    li.appendChild(removeButton);

    $('.dishesList').append(li);
}

function removeDishesDOM() {
    if ($('.dishesList').children().length > 1) {
        var addButton = document.querySelector('#add');
        var removeButton = document.querySelector('#remove');
        $('.dishesList li:last-child').remove();
        $('.dishesList li:last-child').append(addButton);
        $('.dishesList li:last-child').append(removeButton);
    }
}

function update() {
    $.ajax({
        url: '/admin/menu/id=' + localStorage.getItem("MenuToEdit"),
        dataType: 'json',
        success: function (data) {
            $('#name').val(data.name);
            var dishes = data.dishes;
            for(var i = 0; i < dishes.length; i++) {
                addDishesDOM();
                $('#' + (i + 1)).val(dishes[i].name);
            }
            submit(data);
        }

    });
}

function create() {
    addDishesDOM();
    submit();
}

function submit(data) {
    if (data === undefined) {
        data = {};
    }

    $('#editform').submit(function (e) {
        e.preventDefault();
        var name = $('#name').val();
        var dishNumber = $('.dishesList').children().length;
        var dishes = [];
        var dishesFromDB = getDishes();

        for (var i = 0; i < dishNumber; i++){
            var dishName = $('.dishesList #' + (i + 1)).val();

            for (var j = 0; j < dishesFromDB.length; j++){
                if (dishesFromDB[j].name === dishName) {
                    if (!isRepeated(dishes, dishName)) {
                        dishes.push(dishesFromDB[j]);
                    }
                }
            }
        }
        data.name = name;
        data.dishes = dishes;
        console.log(data);
        upload(data);
    });
}

function upload(data) {
    $.ajax({
        url: "/admin/menu/createOrUpdate",
        type: "POST",
        data: JSON.stringify(data),
        contentType: "application/json",
        dataType: "json",
        complete: function () {
            $('.success').toggle();
        }
    });
}

function getDishes() {
    return $.ajax({
        async: false,
        url: '/dishes',
        type: 'get',
        dataType: 'JSON'
    }).responseJSON;

}

function isRepeated(arr, name) {
    var result = false;
    for (var i = 0; i < arr.length; i++) {
        if (arr[i].name === name) {
            result = true;
            break;
        }
    }
    return result;
}