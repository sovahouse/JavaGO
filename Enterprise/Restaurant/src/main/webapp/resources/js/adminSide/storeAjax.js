$(function () {
    $.ajax({
        url: '/store',
        dataType: 'json',
        success: function (data) {
            localStorage.clear();
            var wrapper = document.querySelector('.wrapper');

            $.each(data, function (i, store) {

                var container = document.createElement('div');
                $(container).addClass("container");
                container.innerHTML += '<p> name: ' + store.ingredient.name  + '</p>'+
                    '<p> quantity: ' + store.quantity  + '</p>'+
                    '<p>' + '<a href="#">' + '<button class="edit" name="' + store.id + '">' + 'Edit' + '</button>' + '</a>' +
                    '<button class="delete"  name="' + store.id + '">' + 'Delete' + '</button>' + '</p>';
                wrapper.appendChild(container);
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
                    url: "/store/delete",
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

