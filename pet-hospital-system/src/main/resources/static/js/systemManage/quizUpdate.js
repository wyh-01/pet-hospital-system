/**
 * Created by wyh on 2023/3/22.
 */

'use strict';
var quizUpdate = {};
var quizList = "";
var quizans="";
quizUpdate.initQuiz = function(index,quizEntity){
    quizans=quizans+quizEntity.id+quizEntity.answer+" ";
    var title = "<label>" + index + ". " + quizEntity.question + "</label>";

    var one = "<label class='radio-inline'>" +
        "            <input type='radio' name='"+quizEntity.id+"' value='A' answer='"+quizEntity.answer+"'>" + "A." + quizEntity.choiceList[0] +
        "            </input>" +
        "     </label>";

    var two = "<label class='radio-inline'>" +
        "            <input type='radio' name='"+quizEntity.id+"' value='B' answer='"+quizEntity.answer+"'>" + "B." + quizEntity.choiceList[1] +
        "            </input>" +
        "     </label>";

    var three = "<label class='radio-inline'>" +
        "            <input type='radio' name='"+quizEntity.id+"' value='C' answer='"+quizEntity.answer+"'>" + "C." + quizEntity.choiceList[2] +
        "            </input>" +
        "     </label>";

    var four = "<label class='radio-inline'>" +
        "            <input type='radio' name='"+quizEntity.id+"' value='D' answer='"+quizEntity.answer+"'>" + "D." + quizEntity.choiceList[3] +
        "            </input>" +
        "     </label>";

    var choices = "<div>" + one + two + three + four + "</div>";

    var button = "<div style='margin-top: 20px;'> <button onclick=\"quizUpdate.update(" + quizEntity.id + ")\" type=\"button\" class=\"btn btn-primary btn-lg\">编辑</button>" +
        "<button onclick=\"quizUpdate.delete(" + quizEntity.id +"," + quizEntity.disease_id + ")\" type=\"button\" class=\"btn btn-danger btn-lg\">删除</button></div>";


    return title + choices + button + "<hr/>";

};

quizUpdate.update = function (id){
    window.location.href = "../updateQuiz/" + id;
}

quizUpdate.delete = function (quizId, diseaseId){
    var fd = new FormData();
    fd.append("id", quizId);
    $.ajax({
        contentType : false,
        type: "POST",//方法类型
        processData: false,
        // dataType: "multipart/form-data",//预期服务器返回的数据类型
        url: "/api/quiz/delete" ,//url
        data:fd,
        statusCode : {
            200: function(result){
                alert(result);
                window.location.href = "../quizManage/" + diseaseId;
            },
            400: function(result){
                alert(result.responseText);
                window.location.href = "../quizManage/" + diseaseId;
            }
        }
    });
}

quizUpdate.initQuizList = function (res) {
    for(var i=0;i<res.length;i++){
        quizList = quizList + quizUpdate.initQuiz(i+1,res[i]);
    }
    $("#quizList").html(quizList);
};
var so=0;
quizUpdate.bindModal = function () {
    var item=null

    var score = so;
    //$("#modalText").html(score+"分");
    $('#modalBtn').click(function() {
        location.reload();
    });
}
quizUpdate.set = function () {

    $("input[type=radio]:checked").each(function() {
       var item = $(this).val();
       var ans=this.name+item;
       if(quizans.indexOf(ans)!==-1)
       {
           so+=10
       }

    }
    )
    $("#modalText").html(so+"分");

}
quizUpdate.init = function () {
    var diseaseId = $.getUrlLastParam();
    var req = {
        diseaseId:diseaseId
    };
    comm.utils.postForm("/quiz/all",req,quizUpdate.initQuizList);
    quizUpdate.bindModal();
};