$(function () {


    $.ajax({
        url: 'http://localhost:8080/employees',
        dataType: 'json',
        success: function (data) {
            console.log('data', data);
            var wrapper = document.createElement('div');
            $(wrapper).addClass("wrapper");
            $.each(data, function (i, val) {
                var container = document.createElement('div');
                $(container).addClass("container");
                var figure = document.createElement('figure');
                var inner = '<figcaption>' + 'Name:' + val.name +
                    '<p>' + val.surname + '</p>' +
                    '<p>' + val.phone + '</p>' +
                    '<p>' + val.birthDate.dayOfMonth + '.' + val.birthDate.monthValue + '.' + val.birthDate.year + '</p>' +
                    '<p>' + val.position + '</p>' +
                    '<p>' + val.salary + '</p>' + "</figcaption>";
                console.log("inner", inner);
                figure.innerHTML = inner;
                container.appendChild(figure);
                wrapper.appendChild(container);
            });
            $('body').html(wrapper);
        }
    });


});

