$(function () {
    localStorage.clear();
    optinsGenerator();
    var data = getData();
    $('.submit').click(function (e) {
        e.preventDefault();
        var result = [];
        var tmp = [];
        var date = $('#date').val();
        var waiterName = $('#waiter').val();
        var table = $('#table').val();

        if (date === "") {
            result = data;
        } else {
            for (var i = 0; i < data.length; i++) {
                if (extractDateFromServer(data[i]) === date) {
                    result.push(data[i]);
                }
            }
        }
        if (waiterName !== "") {
            tmp = result;
            result = [];
            for (var i = 0; i < tmp.length; i++) {
                var nameSurname = tmp[i].waiter.name + ' ' + tmp[i].waiter.surname;
                if (nameSurname === waiterName) {
                    result.push(tmp[i]);
                }
            }
        }
        if (table !== "") {
            tmp = result;
            result = [];
            for (var i = 0; i < tmp.length; i++) {
                if ((tmp[i].tableNumber + '') === table) {
                    result.push(tmp[i]);
                }
            }
        }
        deleteItems();
        generateItems(result);
    });
    generateItems(data);
});


function optinsGenerator() {
    var employees = getEmployees();
    var select = document.querySelector('.waiter');
    for (var i = 0; i < employees.length; i++) {
        if (employees[i].position === "WAITER") {
            var option = document.createElement('option');
            option.setAttribute('value', employees[i].name + ' ' + employees[i].surname);
            option.setAttribute('id', employees[i].name + ' ' + employees[i].surname);
            option.innerHTML = employees[i].name + ' ' + employees[i].surname;
            select.appendChild(option);
        }
    }
}

function generateItems(data) {
    var wrapper = document.querySelector('.wrapper');

    $.each(data, function (i, order) {

        var container = document.createElement('div');
        $(container).addClass("container");
        container.innerHTML += '<p>Table number: ' + order.tableNumber + '</p>' + 'Dishes: ';
        $.each(order.dishes, function (i, dish) {
            if (i + 1 !== order.dishes.length) {
                container.innerHTML += dish.name + ', ';
            } else {
                container.innerHTML += dish.name;
            }
        });
        var status = '<p>' + 'Status: ';
        if (order.status === true) {
            status += 'opened</p>';
        } else {
            status += 'closed</p>';
        }
        container.innerHTML += status;
        container.innerHTML += '<p> Date: ' + extractDate(order) + '</p>';
        container.innerHTML += '<p> Waiter: ' + order.waiter.name + ' ' + order.waiter.surname + '</p>';
        wrapper.appendChild(container);
    });
}

function deleteItems() {
    $('.wrapper').empty();
}

function getEmployees() {
    return $.ajax({
        async: false,
        url: '/admin/employees',
        type: 'get',
        dataType: 'JSON'
    }).responseJSON;
}

function getData() {
    return $.ajax({
        async: false,
        url: '/admin/getAllOrders',
        type: 'get',
        dataType: 'JSON'
    }).responseJSON;
}

function extractDateFromServer(val) {
    if (val.date !== null) {
        var day = val.date[2];
        var month = val.date[1];
        var year = val.date[0];
        var result;

        if ((day + "").length === 1) {
            day = "0" + day;
        }
        if ((month + "").length === 1) {
            month = "0" + month;
        }

        result = year + '-' + month + '-' + day;

        return result;
    }
}

function extractDate(val) {
    if (val.date !== null) {
        var day = val.date[2];
        var month = val.date[1];
        var year = val.date[0];
        var result;

        if ((day + "").length === 1) {
            day = "0" + day;
        }
        if ((month + "").length === 1) {
            month = "0" + month;
        }

        result = day + '.' + month + '.' + year;

        return result;
    }
}