$(function () {
    $('#searchButton').click(function () {
        var input = $('#search').val();
        $.ajax({
            url: '/dishes/name=' + input,
            dataType: 'json',
            success: function (data) {
                localStorage.clear();
                localStorage.setItem('dishIdForDishDetail', data.id);
                console.log('local', localStorage);
            }
        });

    });
});
