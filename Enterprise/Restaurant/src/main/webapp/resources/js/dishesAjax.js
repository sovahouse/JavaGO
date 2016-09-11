$(function () {
 $.ajax({
     url: '/dishes',
     dataType: 'json',
     success: function (data) {
         localStorage.clear();
         console.log('data', data);
         var menu = document.querySelector('.menu');
         $.each(data, function (i, val) {
         var list = document.createElement('figure');
             list.innerHTML +=  '<a href="/dishes/dishdetail" class="sendId" name="' + val.id + '"> <figcaption>' + '<img src="' + val.photo + '">' +
                 '</figcaption>' + val.name + ' ' + val.weight + 'g<br>' + val.price + ' UAH' + '</a>';
             menu.appendChild(list);

         });

         $('.sendId').click(function() {
             var id = $(this).attr("name");
             localStorage.setItem('dishIdForDishDetail', id);
         });

     }
 });
});