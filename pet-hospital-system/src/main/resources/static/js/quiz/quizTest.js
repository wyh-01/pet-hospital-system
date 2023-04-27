/**
 * Created by wyh on 2023/3/22.
 */

'use strict';
var quizTest = {};
var quizList = "";
var quizans="";
var outcome="";
quizTest.initQuiz = function(index,quizEntity){
    quizans=quizans+quizEntity.id+quizEntity.answer+" ";
    var title = "<label>" + index + ". " + quizEntity.question + "</label>";

    var one = "<label class='radio-inline'>" +
        "            <input type='radio' name='"+quizEntity.id+"' value='A' answer='"+quizEntity.answer+"'>" + "A." +  quizEntity.choiceList[0] +
        "            </input>" +
        "     </label>";

    var two = "<label class='radio-inline'>" +
        "            <input type='radio' name='"+quizEntity.id+"' value='B' answer='"+quizEntity.answer+"'>" + "B." +  quizEntity.choiceList[1] +
        "            </input>" +
        "     </label>";

    var three = "<label class='radio-inline'>" +
        "            <input type='radio' name='"+quizEntity.id+"' value='C' answer='"+quizEntity.answer+"'>" + "C." +  quizEntity.choiceList[2] +
        "            </input>" +
        "     </label>";

    var four = "<label class='radio-inline'>" +
        "            <input type='radio' name='"+quizEntity.id+"' value='D' answer='"+quizEntity.answer+"'>" + "D." +  quizEntity.choiceList[3] +
        "            </input>" +
        "     </label>";

    var choices = "<div>" + one + two + three + four + "</div>";

    return title + choices + "<hr/>";

};

quizTest.initOutcome = function(index,quizEntity, item){
    quizans=quizans+quizEntity.id+quizEntity.answer+" ";
    var title = "<label>" + index + ". " + quizEntity.question + "</label>";

    var one = "<label class='radio-inline'>" +
        "            <input type='radio' name='"+quizEntity.id+"' value='A' answer='"+quizEntity.answer+"'>" + "A." +  quizEntity.choiceList[0] +
        "            </input>" +
        "     </label>";

    var two = "<label class='radio-inline'>" +
        "            <input type='radio' name='"+quizEntity.id+"' value='B' answer='"+quizEntity.answer+"'>" + "B." +  quizEntity.choiceList[1] +
        "            </input>" +
        "     </label>";

    var three = "<label class='radio-inline'>" +
        "            <input type='radio' name='"+quizEntity.id+"' value='C' answer='"+quizEntity.answer+"'>" + "C." +  quizEntity.choiceList[2] +
        "            </input>" +
        "     </label>";

    var four = "<label class='radio-inline'>" +
        "            <input type='radio' name='"+quizEntity.id+"' value='D' answer='"+quizEntity.answer+"'>" + "D." +  quizEntity.choiceList[3] +
        "            </input>" +
        "     </label>";

    var choices = "<div>" + one + two + three + four + "</div>";
    var ans = "";
    if(item == ""){
        ans = "您未选择答案";
    }else{
        ans = "您选择的答案：" + item;
    }
    return title + choices + "<p style='margin-top: 20px;'>" + ans + "&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp正确答案：" + quizEntity.answer +"</p>" + "<hr/>";

};


quizTest.initQuizList = function (res) {
    outcome = res;
    for(var i=0;i<res.length;i++){
        quizList = quizList + quizTest.initQuiz(i+1,res[i]);
    }
    $("#quizList").html(quizList);
};

quizTest.initOutcomeList = function () {
    quizList = "";
    for(var i=0;i<outcome.length;i++){
        var radio = document.getElementsByName(outcome[i].id.toString());
        var item = "";
        for (var j=0; j<radio.length; j++) {
            if (radio[j].checked) {
                item = radio[j].value;
            }
        }

        quizList = quizList + quizTest.initOutcome(i+1,outcome[i], item);
    }
    $("#quizList").html(quizList);
};
var so=0;
quizTest.bindModal = function () {
    var item=null

    var score = so;
    //$("#modalText").html(score+"分");
    $('#modalBtn').click(function() {
        // location.reload();
    });
}
quizTest.set = function () {

    var i = 0;
    quizList = "";
    $("input[type=radio]:checked").each(function() {
       var item = $(this).val();
       var ans=this.name+item;
       if(quizans.indexOf(ans)!==-1)
       {
           so+=10
       }
    }
    )
    quizTest.initOutcomeList();
    document.getElementById("header1").innerText = "测评结果";
    document.getElementById("header2").innerText = "Quiz Outcome";
    document.getElementById("button-submit").remove();
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