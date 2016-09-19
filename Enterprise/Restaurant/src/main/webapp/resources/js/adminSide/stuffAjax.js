$(function () {
    localStorage.clear();
    var data = getData();
    data.sort(sortById);

    var wrapper = document.querySelector('.wrapper');

    $.each(data, function (i, val) {
        var container = document.createElement('div');
        $(container).addClass("container");
        var figure = document.createElement('figure');

        var id = val.id;
        var name = val.name;
        var surname = val.surname;
        var phone = val.phone;
        var position = val.position;
        var salary = val.salary;
        var photo = val.photo;

        var inner = '<img src="' + photo + '">' + '<figcaption>' + 'Name:' + name +
            '<p>' + 'Surname: ' + surname + '</p>' +
            '<p>' + 'Phone: ' + phone + '</p>' +
            '<p>' + 'Birthday: ' + extractDate(val) + '</p>' +
            '<p>' + 'Position: ' + position + '</p>' +
            '<p>' + 'Salary: ' + salary + ' UAH' + '</p>' + "</figcaption>" +
            '<p>' + '<a href="/admin/employee/edit">' + '<button class="edit" name="' + id + '">' + 'Edit' + '</button>' + '</a>';
            //+'<button class="delete"  name="' + id + '">' + 'Delete' + '</button>' + '</p>';
        figure.innerHTML = inner;
        container.appendChild(figure);
        wrapper.appendChild(container);
    });

    $('.edit').click(function () {
        var id = $(this).attr("name");
        localStorage.setItem("EmployeeToEdit", id);
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
        deleteEmployee(result);
        location.reload();

    });

});

function deleteEmployee(employee) {
    $.ajax({
        url: "/admin/employees/delete",
        type: "POST",
        data: JSON.stringify(employee),
        contentType: "application/json",
        dataType: "json"
    });
}

function getData() {
    return $.ajax({
        async: false,
        url: '/admin/employees',
        type: 'get',
        dataType: 'JSON'
    }).responseJSON;
}

function sortById(a, b) {
    return ((a.id < b.id) ? -1 : ((a.id > b.id) ? 1 : 0));
}

function extractDate(val) {
    if (val.birthDate !== null) {
        var day = val.birthDate[2];
        var month = val.birthDate[1];
        var year = val.birthDate[0];
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

