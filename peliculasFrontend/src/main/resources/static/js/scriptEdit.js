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

$('#volver-listado-peliculas').click(function(e) {
    location.href = "/peliculas/listado";
})

$('#volver-listado-actores').click(function(e) {
    location.href = "/actores/listado";
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
    console.log("endp => " + endp);
    invokeAjax('GET', endp).then(result => {
        location.href = "/actores/listado";
    }).catch((thrownError) => {
        console.log('error');
    });
})
