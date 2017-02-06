var header = $("meta[name='_csrf_header']").attr("content");
var token = $("meta[name='_csrf']").attr("content");
 
$.ajax({
    url: '/test',
    type: 'POST',
    beforeSend: function(xhr){
        xhr.setRequestHeader(header, token);
    },
    success: function(data) {
        console.log(data);
    },
    error: function (xhr, ajaxOptions, thrownError) {
        console.log(xhr.status + ": " + thrownError);
    }
});