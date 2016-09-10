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
             var inner =  '<a href="/dishes/dishdetail" class="sendId" name="' + val.id + '">' + val.name + '<figcaption>' + '<img src="' + val.photo + '">' + '</figcaption>' + '</a>';
             list.innerHTML += inner;
             menu.appendChild(list);

         });
         var sendId = $('.sendId');
         /*sendId.on('click', function (e) {
          e.preventDefault();
          var id = sendId.attr('name');
          console.log("id", id);
          localStorage.setItem('dishIdForDishDetail', id);
          console.log('local', localStorage);
          });*/
         $(document).click(function(event) {
             var text = $(event.target);
             console.log('text', text);
         });
     }
 });
});
//                 var inner = '<figcaption>' + 'Name:' + name +
//                     '<p>' + 'Surname: ' + surname + '</p>' +
//                     '<p>' + 'Phone: ' + phone + '</p>' +
//                     '<p>' + 'Birthday: ' + extractBirthDate(val) + '</p>' +
//                     '<p>' + 'Position: ' + position + '</p>' +
//                     '<p>' + 'Salary: ' + salary + ' UAH' + '</p>' + "</figcaption>" +
//                     '<p class="link">' + '<a href="/editemployee/' + id + '">edit</a>' + '</p>';
//                 console.log("inner", inner);
//                 figure.innerHTML = inner;
//                 container.appendChild(figure);
//                 wrapper.appendChild(container);
//             });
//             $('body').html(wrapper);
//         }
//     });
//
//     function extractBirthDate(birthday) {
//         var day = birthday.birthDate.dayOfMonth;
//         var month = birthday.birthDate.monthValue;
//         var year = birthday.birthDate.year;
//         var result;
//
//         if((day + "").length === 1) {
//             day = "0" + day;
//             console.log("day", day);
//         }
//         if((month + "").length === 1) {
//             month = "0" + month;
//         }
//
//         result = day + '.' + month + '.' + year;
//
//         console.log('result:', result);
//         return result;
//     }
//
//
// });
//

