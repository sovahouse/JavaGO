$(function () {


    $.ajax({
        url: '/employees',
        dataType: 'json',
        success: function (data) {
            console.log('data', data);
            var wrapper = document.createElement('div');
            $(wrapper).addClass("wrapper");
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

                var inner = '<figcaption>' + 'Name:' + name +
                    '<p>' + 'Surname: ' + surname + '</p>' +
                    '<p>' + 'Phone: ' + phone + '</p>' +
                    '<p>' + 'Birthday: ' + extractBirthDate(val) + '</p>' +
                    '<p>' + 'Position: ' + position + '</p>' +
                    '<p>' + 'Salary: ' + salary + ' UAH' + '</p>' + "</figcaption>" +
                    '<p class="link">' + '<a href="/editemployee/' + id + '">edit</a>' + '</p>';
                console.log("inner", inner);
                figure.innerHTML = inner;
                container.appendChild(figure);
                wrapper.appendChild(container);
            });
            $('body').html(wrapper);
        }
    });

    function extractBirthDate(birthday) {
        var day = birthday.birthDate.dayOfMonth;
        var month = birthday.birthDate.monthValue;
        var year = birthday.birthDate.year;
        var result;

        if((day + "").length === 1) {
            day = "0" + day;
            console.log("day", day);
        }
        if((month + "").length === 1) {
            month = "0" + month;
        }

        result = day + '.' + month + '.' + year;

        console.log('result:', result);
        return result;
    }


});

