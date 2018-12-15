
$(document).ready(function(){
    var removeId = {
        id: null
    }

    $("#style-grid").on('click', function () {

        $(".list__item").removeClass('list');
    });

    $("#style-list").on('click', function () {
        $(".list__item").addClass('list');

    });

    $('.slick__wrapper').slick({
        infinite: true,
        slidesToShow: 1,
        slidesToScroll: 1,
        dots: false,
        arrows: true,
        autoplay: true,
        speed: 1300,
        autoplaySpeed: 2000,
        cssEase: 'ease',
        prevArrow: '.slick-prev',
        nextArrow: '.slick-next'
    });

    $('.list__cancel').on('click', function(e) {
        e.preventDefault();
        $('#siteModal').fadeIn(100);
        var idm = $(this).parents('.list__item').attr('id');
        removeId.id = idm;
        console.log(removeId.id)
    })

    $('#btn_yes').on('click', function(e) {
        e.preventDefault();
        $.ajax({
            type: 'POST',
            data: { reqValue : removeId.id},
            url: '/deleteMovie',

            success: function () {
                $('#'+removeId.id).remove();
                $('#siteModal').fadeOut(100);
            },
            error: function () {
                alert("No")
            }
        })
    });

    $('#btn_no, .modal__close').on('click', function(e) {
        e.preventDefault();
        $('#siteModal').fadeOut(100);
    });

   if ($('.particles__wrap').length) {
       particlesJS.load('particles', 'js/particlesjs-config.json');
   }

});

$('.navigation__input').on('click', function() {
   $(this).parents('.navigation__form').trigger('submit');
});

