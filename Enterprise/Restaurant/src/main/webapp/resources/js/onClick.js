$(function () {
   var sendId = $('.sendId');
    sendId.on('click', function (e) {
        e.preventDefault();
        localStorage.setItem('dishIdForDishDetail', val.id)

    })
});
