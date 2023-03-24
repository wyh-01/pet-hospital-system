function login() {
    $.ajax({
        //几个参数需要注意一下
        type: "POST",//方法类型
        dataType: "json",//预期服务器返回的数据类型
        url: "/api/login" ,//url
        data: $('#loginForm').serialize(),
        statusCode : {
            200: function(){
                window.location.href='/index';
            },
            401: function(result){
                alert(result.responseText);
            }
        }
    });
}

function signup() {
    window.location.href = '/signup';
}