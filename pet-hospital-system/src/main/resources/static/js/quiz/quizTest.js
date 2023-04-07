/**
 * Created by wyh on 2023/3/22.
 */

'use strict';
var quizTest = {};
var quizList = "";
var quizans="";
quizTest.initQuiz = function(index,quizEntity){
    quizans=quizans+quizEntity.id+quizEntity.answer+" ";
    var title = "<label>" + index + ". " + quizEntity.question + "</label>";

    var one = "<label class='radio-inline'>" +
        "            <input type='radio' name='"+quizEntity.id+"' value='A' answer='"+quizEntity.answer+"'>" + quizEntity.choiceList[0] +
        "            </input>" +
        "     </label>";

    var two = "<label class='radio-inline'>" +
        "            <input type='radio' name='"+quizEntity.id+"' value='B' answer='"+quizEntity.answer+"'>" + quizEntity.choiceList[1] +
        "            </input>" +
        "     </label>";

    var three = "<label class='radio-inline'>" +
        "            <input type='radio' name='"+quizEntity.id+"' value='C' answer='"+quizEntity.answer+"'>" + quizEntity.choiceList[2] +
        "            </input>" +
        "     </label>";

    var four = "<label class='radio-inline'>" +
        "            <input type='radio' name='"+quizEntity.id+"' value='D' answer='"+quizEntity.answer+"'>" + quizEntity.choiceList[3] +
        "            </input>" +
        "     </label>";

    var choices = "<div>" + one + two + three + four + "</div>";

    return title + choices + "<hr/>";

};

quizTest.initQuizList = function (res) {
    for(var i=0;i<res.length;i++){
        quizList = quizList + quizTest.initQuiz(i,res[i]);
    }
    $("#quizList").html(quizList);
};
var so=0;
quizTest.bindModal = function () {
    var item=null

    var score = so;
    //$("#modalText").html(score+"分");
    $('#modalBtn').click(function() {
        location.reload();
    });
}
quizTest.set = function () {

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
quizTest.init = function () {
    var diseaseId = $.getUrlLastParam();
    var req = {
        diseaseId:diseaseId
    };
    comm.utils.postForm("/quiz/detail",req,quizTest.initQuizList);
    quizTest.bindModal();
};