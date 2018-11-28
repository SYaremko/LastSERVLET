

$('.list__cancel').on('click', function(e) {
 e.preventDefault();

 var idv = $(this).parents('.list__item').attr('id');

 $.ajax({
 type: 'POST',
 data: { reqValue : idv},
 url: '/deletePerson',

 success: function () {
 $('#'+idv).remove();

 },
 error: function () {
 alert("No")
 }
 })
 });
