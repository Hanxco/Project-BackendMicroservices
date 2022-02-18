// AJAX Functions works with SaveAndResponseWrapper class
function invokeAjax(endpoint) {
    return new Promise(function(resolve, reject) {
        $.ajax({
            type : 'GET',
            url : endpoint,
            success : function(result) {
                resolve(result);
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
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            url : endpoint,
            dataType: 'json',
            data: JSON.stringify(data),
            success : function(result) {
                resolve(result);
            },
            error : function(thrownError) {
                reject(thrownError);
            }
        });
    });
}
