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
