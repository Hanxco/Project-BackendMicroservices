$(document).ready(function() {
    $('[data-toggle=tooltip]').tooltip();
});

var $play = $('.play'),
    $detail  = $('.detail'),
    $movie = $('.movie', $detail),
    $close = $('.close');

var $criticaPeli = false;

$('.movies .movie').click(function() {
    var criticasUser = $('#setCriticasUser').val().split(',');
    var peliculaId = $(this).children(":first").val();
    getRatingAverage(peliculaId);

    if (criticasUser.includes(peliculaId)) {
        $(this).children("div.rating").hide()
        $(this).children("div.rating-complete").show()
    }

    let movieId = $(this).find(">:first-child").text();
    $movie.html($(this).html());
    $play.appendTo($movie);

    $poster = $('.poster', this).addClass('active');
    console.log('poster');
    console.log($poster);

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
    console.log('Close function');
    if ($criticaPeli) {
        location.href = "/";
    } else {
        $p = $('.detail .poster');
        $p.css({
            top: $p.data('top'),
            left: $p.data('left'),
            width: $p.data('width'),
            height: $p.data('height'),
        })
        $detail.removeClass('ready').delay(200).queue(function(next){
            $(this).hide();
            $poster.removeClass('active');
            next();
        });
    }
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

/*
CRITICAS
 */
$('.listado-criticas-tr').click(function(e) {
    var idElement = $(this).children().first().text();
    location.href = "/criticas/editar/"+idElement;
})

/*
USUARIOS
*/
$('.listado-usuarios-tr').click(function(e) {
    var idElement = $(this).children().first().text();
    console.log('idElement => ' + idElement);
    location.href = "/usuarios/editar/"+idElement;
})

/*
PELICULAS
 */
$('#nueva-pelicula').click(function(e) {
    location.href = "/peliculas/crear";
})

$('.listado-peliculas-tr').click(function(e) {
    var idElement = $(this).children().first().text();
    location.href = "/peliculas/editar/"+idElement;
})


/*
ACTORES
 */
$('.listado-actores-tr').click(function(e) {
    var idElement = $(this).children().first().text();
    location.href = "/actores/editar/"+idElement;
})

$('#nuevo-actor').click(function(e) {
    location.href = "/actores/crear";
})

/*
LOGIN & LOGOUT
 */
$('#logout-btn').click(function(e) {
    location.href = "/logout";
})

$('#registro-btn').click(function(e) {
    location.href = "/usuarios/registrar";
})

function changeSelect(obj, peliculaId) {
    $('input#selected-rating-' + peliculaId).val(obj.value);
}

function onRating(obj, peliculaId, userId) {
    var valueRating = $('input#selected-rating-' + peliculaId).val();
    var parent = $(obj).parent().parent().children();
    var valoracion = parent.children('textarea#valoracion').val();
    var data = {
        'peliculaId' : peliculaId,
        'valoracion' : valoracion,
        'nota' : valueRating
    };
    var parentMain = $(obj).parent().parent().parent();
    var notification = parentMain.children('div.rating-complete');
    var alertElement = notification.children();
    const endp = 'http://localhost:8002/criticas/' + userId;
    invokeAjaxPost(endp, data).then(result => {
        parentMain.children('div.rating-complete').show();
        if (result.code == 200) {
            $criticaPeli = true;
            parentMain.children('div.rating').hide();
            alertElement.removeClass('alert-warning').addClass('alert-success');
            alertElement.text('Su crítica ha sido registrada. Gracias por contribuir!');
            var parent = $movie.children('div.rating-medio').children().remove();
            getRatingAverage(peliculaId);
        } else {
            alertElement.removeClass('alert-warning').addClass('alert-danger');
            alertElement.text('Error en el sistema!');
        }
    }).catch((thrownError) => {
        console.log('error');
    });
}

function getRatingAverage(peliculaId) {
    invokeAjax('http://localhost:8002/criticas/pelicula/'+peliculaId+'/media').then(result => {
        var starFill = '<i class="fa-solid fa-star fa-2xl"></i>';
        var starEmpty = '<i class="fa-regular fa-star fa-2xl"></i>';
        for (i=1 ; i<=10; i++) {
            var parent = $movie.children('div.rating-medio');
            $movie.children('b.valoracion-text').text('Valoración media: ' + result + '/10');
            if (i <= result) {
                parent.append(starFill);
            } else {
                parent.append(starEmpty);
            }
        }
    }).catch((thrownError) => {
        console.log('error');
    });
}

function verMasCriticas(obj, peliculaId) {
    var objContainer = $movie.children('div.container-criticas').children(":first");
    objContainer.empty();
    invokeAjax('http://localhost:8002/criticas/pelicula/'+peliculaId).then(result => {
        result.forEach(function(elemento, indice, array) {
            var card = '<div class="card mt-3">' +
                '  <div class="card-body">' +
                '<i class="fa-solid fa-user"></i> Usuario' +
                '<i class="fa-solid fa-calendar p-3"></i>' + elemento.fecha + '\n' +
                '<i class="fa-solid fa-face-grin-stars ms-3"></i> Calificación: ' + elemento.nota + '\n' +
                '<div class="p-3"><b>Valoración: </b>' + elemento.valoracion + '</div>\n' +
                '  </div>' +
                '</div>';
            card = card.replace("\n","<br /><br />")
            objContainer.append(card);
        })
    }).catch((thrownError) => {
        console.log('error');
    });
}

$("#search-element").on("keyup", function(){
    // Print entered value in a div box
    console.log($("#search-element").text($(this).val()));
    console.log($(this));
    $('#table-searched').show();
    var value = $(this).val();
    var patt = new RegExp(value, "i");
    $('#table-searched-group').find('li').each(function() {
        var $table = $('#table-searched-group');
        if (($(this).text().search(patt) >= 0)) {
            $(this).show();
        } else {
            $(this).hide();
        }
    });
});

$('.itemBuscador').click(function(e) {
    location.href = "/peliculas/editar/" + $(this).attr('id').split('-')[1];
});

