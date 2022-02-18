// AJAX Functions works with SaveAndResponseWrapper class
function invokeAjax(method, endpoint) {
    return new Promise(function(resolve, reject) {
        $.ajax({
            type : method,
            url : endpoint,
            success : function(result) {
                resolve();
            },
            error : function(thrownError) {
                reject(thrownError);
            }
        });
    });
}

$('#nuevo-actor').click(function(e) {
    location.href = "/actores/crear";
})

$('#eliminar-pelicula-btn').click(function(e) {
    const endp = '/peliculas/eliminar/' + $('#pelicula-id').val();
    invokeAjax('GET', endp).then(result => {
        location.href = "/peliculas/listado";
    }).catch((thrownError) => {
        console.log('error');
    });
})

$('#eliminar-actor-btn').click(function(e) {
    const endp = '/actores/eliminar/' + $('#id-actor').val();
    invokeAjax('GET', endp).then(result => {
        location.href = "/actores/listado";
    }).catch((thrownError) => {
        console.log('error');
    });
})

$('#eliminar-critica-btn').click(function(e) {
    const endp = '/criticas/eliminar/' + $('#criticas-id').val();
    invokeAjax('GET', endp).then(result => {
        location.href = "/criticas/listado";
    }).catch((thrownError) => {
        console.log('error');
    });
});

/* BUSCADOR DE ACTORES */
$('#search-member-input').on('keyup', function() {
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
    console.log($(this));
    $(this).remove();
    let endpoint = 'http://localhost:8001/peliculas/' + $('#pelicula-id').val() + '/actor/' + $(this).attr('id').split('-')[1];
    invokeAjax('PUT', endpoint).then(result => {
        location.reload(true);
        location.href = "/peliculas/listado";
    }).catch((thrownError) => {
        console.log('error');
    });
});

function deleteActor(obj, actorId) {
    var parentElem = $(obj).parent().parent().parent().parent().parent().parent().parent().parent();
    var peliculaId = parentElem.children().eq(1).children(':first').val();
    let endpoint = 'http://localhost:8001/peliculas/' + peliculaId + '/actor/' + actorId;
    invokeAjax('DELETE', endpoint).then(result => {
        $(obj).parent().parent().parent().parent().parent().parent().remove()
    }).catch((thrownError) => {
        console.log('error');
    });
}

/* BOTONES VOLVER */
$('#volver-listado-usuarios').click(function(e) {
    location.href = "/usuarios/listado";
})
$('#volver-listado-criticas').click(function(e) {
    location.href = "/criticas/listado";
})
$('#volver-listado-peliculas').click(function(e) {
    location.href = "/peliculas/listado";
})
$('#volver-listado-actores').click(function(e) {
    location.href = "/actores/listado";
})

