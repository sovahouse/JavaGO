$(function () {
    localStorage.clear();
    var data = getData();
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
        container.innerHTML += '<p> Date: ' + order.date[2] + '.' + order.date[1] + '.' + order.date[0] + '</p>';
        container.innerHTML += '<p> Waiter: ' + order.waiter.name + ' ' + order.waiter.surname + '</p>';
        wrapper.appendChild(container);
    });
});

function getData() {
    return $.ajax({
        async: false,
        url: '/orders',
        type: 'get',
        dataType: 'JSON'
    }).responseJSON;
}
