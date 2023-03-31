function signup() {
    $.ajax({
        //几个参数需要注意一下
        type: "POST",//方法类型
        dataType: "json",//预期服务器返回的数据类型
        url: "/api/signup" ,//url
        data: $('#signupForm').serialize(),
        statusCode : {
            200: function(){
                window.location.href='/';
            },
            400: function(result){
                alert(result.responseText);
            }
        }
    });
}