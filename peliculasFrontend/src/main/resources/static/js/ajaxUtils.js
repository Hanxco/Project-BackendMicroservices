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

function invokeAjaxPost(endpoint, data) {
    return new Promise(function(resolve, reject) {
        $.ajax({
            type : 'POST',
            url : endpoint,
            data: data,
            success : function(result) {
                resolve();
            },
            error : function(thrownError) {
                reject(thrownError);
            },
            dataType: 'json'
        });
    });
}
