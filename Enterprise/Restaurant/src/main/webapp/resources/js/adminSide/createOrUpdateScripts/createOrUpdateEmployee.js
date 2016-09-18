$(function () {
    if(localStorage.getItem("EmployeeToEdit") !== null) {
        update();
    } else {
        create();
    }
});

function update() {
    $.ajax({
        url: '/employees/id=' + localStorage.getItem("EmployeeToEdit"),
        dataType: 'json',
        success: function (data) {
            $('#name').val(data.name);
            $('#surmane').val(data.surname);
            $('#birthdate').val(extractDate(data));
            $('#position').val(data.position);
            $('#salary').val(data.salary);
            submit(data);
        }

    });
}

function create() {
    submit();
}

function submit(data) {
    if (data === undefined) {
        data = {};
    }

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
            $('.error').toggle();
            throw new Error("invalid name input");
        }

        data.surname = surname;
        data.birthDate = birthDate;
        data.position = position.toUpperCase();
        data.salary = salary;

        upload(data);
    });
}

function upload(data) {
    $.ajax({
        url: "/employees/createOrUpdate",
        type: "POST",
        data: JSON.stringify(data),
        contentType: "application/json",
        dataType: "json"
    });
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

        result = year + '-' + month + '-' + day;

        return result;
    }
}

function isAlpha(s) {
    return s.match("^[a-zA-Z]");
}
