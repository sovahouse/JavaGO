(function($) {
    $(function() {
        var jcarousel = $('.jcarousel').jcarousel();

        // $('.jcarousel-control-prev')
        //     .on('jcarouselcontrol:active', function() {
        //         $(this).removeClass('inactive');
        //     })
        //     .on('jcarouselcontrol:inactive', function() {
        //         $(this).addClass('inactive');
        //     })
        //     .jcarouselControl({
        //         target: '-=1'
        //     });
        //
        // $('.jcarousel-control-next')
        //     .on('jcarouselcontrol:active', function() {
        //         $(this).removeClass('inactive');
        //     })
        //     .on('jcarouselcontrol:inactive', function() {
        //         $(this).addClass('inactive');
        //     })
        //     .jcarouselControl({
        //         target: '+=1'
        //     });
        $('.jcarousel-pagination')
            .on('jcarouselpagination:active', 'a', function() {
                $(this).addClass('active');
            })
            .on('jcarouselpagination:inactive', 'a', function() {
                $(this).removeClass('active');
            })
            .jcarouselPagination();

        $.ajax({
            url: '/dishes',
            dataType: 'json',
            success: function (data) {
                var html = '<ul>';
                $.each(data, function (i, val) {
                    html += '<li><img src="' + val.photo + '" alt="' + val.name + '"></li>';
                });
                html += '</ul>';

                // Append items
                jcarousel
                    .html(html);

                // Reload carousel
                jcarousel
                    .jcarousel('reload');
            }
        });
    });
})(jQuery);
