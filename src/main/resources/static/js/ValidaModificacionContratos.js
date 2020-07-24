$('.numeric').keyup(function() {
    var $th = $(this);
    $th.val( $th.val().replace(/[^0-9]/g, '') );
});

$('.alpha_numeric_plus').keyup(function() {
    var $th = $(this);
    $th.val( $th.val().replace(/[^a-zA-Z0-9ÁÉÍÓÚÑáéíóúñ\s\\&\\.\\,\\#]/g, '') );
});