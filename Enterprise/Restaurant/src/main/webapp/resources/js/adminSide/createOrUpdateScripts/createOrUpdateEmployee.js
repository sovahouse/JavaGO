$(function () {
    if(localStorage.getItem("EmployeeToEdit") !== null) {
        update();
    } else {
        create();
    }
});

function update() {
    $.ajax({
        url: '/admin/employees/id=' + localStorage.getItem("EmployeeToEdit"),
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

        if(isNameValid(name)) {
            data.name = name;
        } else {
            $('.errorName').toggle();
            throw new Error("invalid name input");
        }
        if(isNameValid(surname)) {
            data.surname = surname;
        } else {
            $('.errorSurname').toggle();
            throw new Error("invalid surname input");
        }

        data.birthDate = birthDate;
        data.position = position;

        if(isSalaryValid(salary)) {
            data.salary = salary;
        } else {
            $('.errorSalary').toggle();
            throw new Error("invalid salary input");
        }


        upload(data);
    });
}

function upload(data) {
    $.ajax({
        url: "/admin/employees/createOrUpdate",
        type: "POST",
        data: JSON.stringify(data),
        contentType: "application/json",
        dataType: "json",
        complete: function () {
            $('.success').toggle();
        }
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

function isSalaryValid(quantity) {
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
