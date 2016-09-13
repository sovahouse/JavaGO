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

                if(name !== null && name !== "") {
                    data.name = name;
                }
                if(surname !== null && surname !== "") {
                    data.surname = surname;
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
                $('#back').on('click', function () {
                    window.location.replace("/admin/stuff");
                });

            });
        }

    });

});
