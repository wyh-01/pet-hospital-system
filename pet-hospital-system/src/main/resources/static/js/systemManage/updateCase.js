/**
 * Created by wyh on 2023/3/22.
 */

'use strict';

var updateCase = {};

updateCase.initTitle = function (res) {
    $("#d-name").html(res.name);
    var image = "<p id='disease-image-list'>" + updateCase.initImageList(res.imageList) + "</p>";
    var d = document.getElementById("d-image");
    d.innerHTML = image;
    $("#d-description").html(res.description);
};

updateCase.initImageList = function (imageList) {
    var images = "";
    for(var i=0;i<imageList.length;i++){
        images = images + "<img src=" + imageList[i] + " alt='' width='200px' height='200px'/>";
    }
    return images;
};

updateCase.initSingleCase = function (caseEntity) {
    var name = "<div style='font-size: 1.5em;'>" + caseEntity.name + "</div>";
    var description = "<p>" + caseEntity.description + "</p>";
    var images = "<div style='font-size: 1.5em;'>相关图例</div>" + "<p id='image-list'>" + updateCase.initImageList(caseEntity.imageList) + "</p>";
    var dVideo = "";
    if(caseEntity.video){
        dVideo = "<div style='font-size: 1.5em;'>相关视频</div>" + "<video width=\"320\" height=\"240\" controls=\"autoplay\">" +
            "<source src=\"" + caseEntity.video +
             "\" type=\"video/mp4\"/> </video>";
    }

    var button = "<div> <button onclick=\"updateCase.update(" + caseEntity.id + ")\" type=\"button\" class=\"btn btn-primary btn-xs\">编辑</button>" +
        "<button onclick=\"updateCase.delete(" + caseEntity.id +"," + caseEntity.disease_id + ")\" type=\"button\" class=\"btn btn-danger btn-xs\">删除</button></div>";
    var cell = "<li>" +
        name + button + description + images + dVideo +
        "      </li>" +
        "<hr />";
    return cell;
};

updateCase.update = function (id){
    window.location.href = "../updateCase/" + id;
}

updateCase.delete = function (caseId, diseaseId){
    var fd = new FormData();
    fd.append("id", caseId);
    $.ajax({
        contentType : false,
        type: "POST",//方法类型
        processData: false,
        // dataType: "multipart/form-data",//预期服务器返回的数据类型
        url: "/api/caseManage/caseDelete" ,//url
        data:fd,
        statusCode : {
            200: function(){
                window.location.href = "../caseManage/" + diseaseId;
            },
            400: function(){
                window.location.href = "../caseManage/" + diseaseId;
            }
        }
    });
}

updateCase.initCaseList  = function (res) {
    var cases = "";
    for(var i=0;i<res.caseList.length;i++){
        cases = cases + updateCase.initSingleCase(res.caseList[i]);
    }
    $(".work-list").html(cases);
};

updateCase.initPage = function (res) {
    updateCase.initTitle(res);
    updateCase.initCaseList(res);
;};

updateCase.init = function () {
    var diseaseId = $.getUrlLastParam();
    var req = {
        diseaseId:diseaseId
    };
    comm.utils.postForm("/disease/detail",req,updateCase.initPage);
};