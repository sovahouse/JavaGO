$(function () {
    $.ajax({
        url: '/menu',
        dataType: 'json',
        success: function (data) {
            localStorage.clear();
            var wrapper = document.querySelector('.wrapper');

            $.each(data, function (i, menu) {

                var container = document.createElement('div');
                $(container).addClass("container");
                container.innerHTML += '<p>' + menu.name  + '</p>'+
                    '<p>' + '<a href="#">' + '<button class="edit" name="' + menu.name + '">' + 'Edit' + '</button>' + '</a>' +
                    '<button class="delete"  name="' + menu.name + '">' + 'Delete' + '</button>' + '</p>';
                wrapper.appendChild(container);
            });
            $('.delete').click(function (){
                var name = $(this).attr("name");
                var result = {};
                for (var i = 0; i < data.length; i++) {
                    if (data[i].name === name) {
                        result = data[i];
                        break;
                    }
                }
                $.ajax({
                    url: "/menu/delete",
                    type: "POST",
                    data: JSON.stringify(result),
                    contentType:"application/json",
                    dataType:"json"
                });
                location.reload();

            });
        }
    });
});
