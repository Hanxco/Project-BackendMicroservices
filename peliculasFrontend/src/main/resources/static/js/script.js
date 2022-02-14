var $play = $('.play'),
    $detail  = $('.detail'),
    $movie = $('.movie', $detail),
    $close = $('.close');

$('.movies .movie').click(function() {
    console.log('abriendo movie');
    let movieId = $(this).find(">:first-child").text();
    console.log(movieId);
    $movie.html($(this).html());
    $play.appendTo($movie);

    $poster = $('.poster', this).addClass('active');

    $('.poster', $detail).css({
        top: $poster.position().top,
        left: $poster.position().left,
        width: $poster.width(),
        height: $poster.height()
    }).data({
        top: $poster.position().top,
        left: $poster.position().left,
        width: $poster.width(),
        height: $poster.height()
    })

    $detail.show();

    $('.poster', $detail).delay(10).queue(function(next) {
        $detail.addClass('ready');

        next();
    }).delay(100).queue(function(next){
        $(this).css({
            top: '5%',
            left: '-6%',
            width: 266,
            height: 400
        });
        next();
    })
})

function close(){
    console.log('asd');
    $p = $('.detail .poster');
    console.log($p)
    $p.css({
        top: $p.data('top'),
        left: $p.data('left'),
        width: $p.data('width'),
        height: $p.data('height'),
    })
    $detail.removeClass('ready').delay(500).queue(function(next){
        $(this).hide();
        $poster.removeClass('active');
        next();
    });
}

$close.click(close);
$('body').click(function(e){
    $p = $(e.target).parents();
    if ($p.is('.app')){
        return false;
    } else {
        close();
    }
})

$('#navbar').click(function(e) {
    $('#main-menu').show().fadeIn("slow");
})

$('#main-menu li').click(function(e) {
    var href = $(this).find("a").attr('href');
    console.log('href )>' + href);
    location.href = href;
})

$('#logoFilm').click(function(e) {
    location.href = "/";
})

$('#nueva-pelicula').click(function(e) {
    location.href = "/peliculas/crear";
})

$('.listado-peliculas-tr').click(function(e) {
    var idElement = $(this).children().first().text();
    location.href = "/peliculas/editar/"+idElement;
})

$('#volver-listado-peliculas').click(function(e) {
    location.href = "/peliculas/listado";
})

$('.listado-actores-tr').click(function(e) {
    var idElement = $(this).children().first().text();
    location.href = "/actores/editar/"+idElement;
})

$('#nuevo-actor').click(function(e) {
    location.href = "/actores/crear";
})

$('#logout-btn').click(function(e) {
    location.href = "/logout";
})

$('#registro-btn').click(function(e) {
    location.href = "/usuarios/registrar";
})

function changeSelect(obj, peliculaId) {
    $('input#selected-rating-' + peliculaId).val(obj.value);
}

function onRating(peliculaId) {
    var valueRating = $('input#selected-rating-' + peliculaId).val();
    console.log(valueRating);
    var data = {
        'peliculaId' : peliculaId,
        'valoracion' : 'skskksd',
        'nota' : valueRating,
        'fecha' : '2022-01-02'
    };
    console.log(data);
    const endp = '/criticas/1';
    invokeAjax(endp, data).then(result => {
        console.log(result);
        location.href = "/";
    }).catch((thrownError) => {
        console.log('error');
    });
}
