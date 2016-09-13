$(function () {
    $.ajax({
        url: '/employees',
        dataType: 'json',
        success: function (data) {
            localStorage.clear();
            var employees = document.createElement('div');
            $(employees).addClass("employees");
            data.sort(sortById);

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
                    '<p>' + 'Birthday: ' +/* + extractBirthDate(val) + */'</p>' +
                    '<p>' + 'Position: ' + position + '</p>' +
                    '<p>' + 'Salary: ' + salary + ' UAH' + '</p>' + "</figcaption>" +
                    '<p>' +'<a href="/admin/employee/edit">' + '<button class="edit" name="'+ id + '">' + 'Edit' + '</button>' +'</a>' +
                    '<button class="delete"  name="' + id + '">' + 'Delete' + '</button>' + '</p>';
                console.log("inner", inner);
                figure.innerHTML = inner;
                container.appendChild(figure);
                employees.appendChild(container);
            });
            $('body').html(employees);

            $('.edit').click(function (){
                var id = $(this).attr("name");
                localStorage.setItem("EmployeeToEdit", id);
            });
            $('.delete').click(function (){
                var id = $(this).attr("name");
                var result = {};
                for (var i = 0; i < data.length; i++) {
                    if (data[i].id == id) {
                        result = data[i];
                        break;
                    }
                }
                $.ajax({
                    url: "/employees/delete",
                    type: "POST",
                    data: JSON.stringify(result),
                    contentType:"application/json",
                    dataType:"json"
                });
                location.reload();

            });
        }
    });

    function sortById(a, b){
        return ((a.id < b.id) ? -1 : ((a.id > b.id) ? 1 : 0));
    }

    function extractBirthDate(birthday) {
        var day = birthday.birthDate.dayOfMonth;
        var month = birthday.birthDate.monthValue;
        var year = birthday.birthDate.year;
        var result;

        if ((day + "").length === 1) {
            day = "0" + day;
            console.log("day", day);
        }
        if ((month + "").length === 1) {
            month = "0" + month;
        }

        result = day + '.' + month + '.' + year;

        console.log('result:', result);
        return result;
    }


});

