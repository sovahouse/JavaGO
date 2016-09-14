$(function () {
    $.ajax({
        url: '/employees/id=' + localStorage.getItem("EmployeeToEdit"),
        dataType: 'json',
        success: function (data) {
            $('#editform').submit(function (e) {
                e.preventDefault();
                var photo = $('#photo').val();
                var name = $('#name').val();
                var surname = $('#surmane').val();
                var birthDate = $('#birthdate').val();
                var position = $('#position').val();
                var salary = $('#salary').val();

                if(isAlpha(name) && name !== "") {
                    data.name = name;
                } else if(!isAlpha(name) && name !== "") {
                    console.error("invalid input"); //TODO: вывод ошибки на екран
                }

                if(isAlpha(surname) && surname !== "") {
                    data.surname = surname;
                } else if(!isAlpha(surname) && surname !== "") {
                    console.error("invalid input"); //TODO: вывод ошибки на екран
                }

                if(birthDate !== null && birthDate !== "") {
                    data.birthDate = birthDate;
                }
                if(position !== null && position !== "") {
                    data.position = position.toUpperCase();
                }
                if(salary !== null && salary !== "") {
                    data.salary = salary;
                }

                $.ajax({
                    url: "/employees/createOrUpdate",
                    type: "POST",
                    data: JSON.stringify(data),
                    contentType:"application/json",
                    dataType:"json"
                });

            });
        }

    });

});

function isAlpha(s)
{
    return s.match("^[a-zA-Z]");
}
