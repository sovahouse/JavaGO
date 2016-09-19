$(function () {
    if (localStorage.getItem("DishToEdit") !== null) {
        update();
    } else {
        create();
    }
});

$(function () {
    $('.ingredientsList').on('click', '#add', function () {
        addIngredientsDOM();
    });
    $('.ingredientsList').on('click', '#remove', function () {
        removeIngredientsDOM();
    });
});

function addIngredientsDOM() {
    $('#add').remove();
    $('#remove').remove();

    var ingredientsNumber = $('.ingredientsList').children().length;
    var data = getIngredients();

    var li = document.createElement('li');
    var label = document.createElement('label');
    var select = document.createElement('select');
    var addButton = document.createElement('button');
    var removeButton = document.createElement('button');
    select.setAttribute('name', 'ingredients');
    select.setAttribute('id', ingredientsNumber + 1);
    label.setAttribute('for', 'ingredients');
    addButton.setAttribute('id', 'add');
    addButton.setAttribute('type', 'button');
    removeButton.setAttribute('id', 'remove');
    removeButton.setAttribute('type', 'button');

    label.innerHTML = 'Ingredient ' + (ingredientsNumber + 1) + ':';
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

    $('.ingredientsList').append(li);
}

function removeIngredientsDOM() {
    if ($('.ingredientsList').children().length > 1) {
        var addButton = document.querySelector('#add');
        var removeButton = document.querySelector('#remove');
        $('.ingredientsList li:last-child').remove();
        $('.ingredientsList li:last-child').append(addButton);
        $('.ingredientsList li:last-child').append(removeButton);
    }
}

function update() {
    $.ajax({
        url: '/dishes/id=' + localStorage.getItem("DishToEdit"),
        dataType: 'json',
        success: function (data) {
            $('#name').val(data.name);
            $('#price').val(data.price);
            $('#category').val(data.category);
            $('#weight').val(data.weight);
            var ingredients = data.ingredients;
            if (ingredients.length === 0) {
                addIngredientsDOM();
            } else {
                for (var i = 0; i < ingredients.length; i++) {
                    addIngredientsDOM();
                    $('#' + (i + 1)).val(ingredients[i].name);
                }
            }
            submit(data);
        }

    });
}

function create() {
    addIngredientsDOM();
    submit();
}

function submit(data) {
    if (data === undefined) {
        data = {};
    }

    $('#editform').submit(function (e) {
        e.preventDefault();
        var name = $('#name').val();
        var price = $('#price').val();
        var category = $('#category').val();
        var weight = $('#weight').val();
        var ingredientsNumber = $('.ingredientsList').children().length;
        var ingredients = [];
        var ingredientsFromDB = getIngredients();

        for (var i = 0; i < ingredientsNumber; i++) {
            var ingredientName = $('.ingredientsList #' + (i + 1)).val();

            for (var j = 0; j < ingredientsFromDB.length; j++) {
                if (ingredientsFromDB[j].name === ingredientName) {
                    if (!isRepeated(ingredients, ingredientName)) {
                        ingredients.push(ingredientsFromDB[j]);
                    }
                }
            }
        }

        if(isNameValid(name)) {
            data.name = name;
        } else {
            $('.errorName').toggle();
            throw new Error("invalid name input");
        }
        if(isDigitValid(price)) {
            data.price = price;
        } else {
            $('.errorPrice').toggle();
            throw new Error("invalid price input");
        }
        if(isNameValid(category)) {
            data.category = category;
        } else {
            $('.errorCategory').toggle();
            throw new Error("invalid category input");
        }
        if(isDigitValid(weight)) {
            data.weight = weight;
        } else {
            $('.errorWeight').toggle();
            throw new Error("invalid weight input");
        }

        data.ingredients = ingredients;
        upload(data);
    });
}

function upload(data) {
    $.ajax({
        url: "/admin/dishes/createOrUpdate",
        type: "POST",
        data: JSON.stringify(data),
        contentType: "application/json",
        dataType: "json",
        complete: function () {
            $('.success').toggle();
        }
    });
}

function getIngredients() {
    return $.ajax({
        async: false,
        url: '/admin/getAllIngredients',
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

function isDigitValid(quantity) {
    var result = true;
    if(!$.isNumeric(quantity)) {
        result = false;
    }
    return result;
}

function isNameValid(name) {
    var result = true;
    if(!isAlpha(name)) {
        result = false;
    }
    return result;
}

function isAlpha(s) {
    return s.match("^[a-zA-Z]");
}