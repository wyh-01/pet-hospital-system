/**
 * Created by wyh on 2023/3/22.
 */

'use strict';

var diseaseDetail = {};

diseaseDetail.initTitle = function (res) {
    $("#d-name").html(res.name);
    var image = "<p id='disease-image-list'>" + diseaseDetail.initImageList(res.imageList) + "</p>";
    var d = document.getElementById("d-image");
    d.innerHTML = image;
    $("#d-description").html(res.description);
};

diseaseDetail.initImageList = function (imageList) {
    var images = "";
    for(var i=0;i<imageList.length;i++){
        images = images + "<img src=" + imageList[i] + " alt='' width='200px' height='200px'/>";
    }
    return images;
};

diseaseDetail.initSingleCase = function (caseEntity) {
    var name = "<p>" + caseEntity.name + "</p>";
    var description = "<p>" + caseEntity.description + "</p>";
    var images = "<p>相关图例</p>" + "<p id='image-list'>" + diseaseDetail.initImageList(caseEntity.imageList) + "</p>";
    var dVideo = "";
    if(caseEntity.video){
        dVideo = "<p>相关视频</p>" + "<video width=\"320\" height=\"240\" controls=\"autoplay\">" +
            "<source src=\"" + caseEntity.video +
             "\" type=\"video/mp4\"/> </video>";
    }
    var cell = "<li>" +
        name + description + images + dVideo +
        "      </li>" +
        "<hr />";
    return cell;
};

diseaseDetail.initCaseList  = function (res) {
    var cases = "";
    for(var i=0;i<res.caseList.length;i++){
        cases = cases + diseaseDetail.initSingleCase(res.caseList[i]);
    }
    $(".work-list").html(cases);
};

diseaseDetail.initPage = function (res) {
    diseaseDetail.initTitle(res);
    diseaseDetail.initCaseList(res);
;};

diseaseDetail.init = function () {
    var diseaseId = $.getUrlLastParam();
    var req = {
        diseaseId:diseaseId
    };
    comm.utils.postForm("/disease/detail",req,diseaseDetail.initPage);
};