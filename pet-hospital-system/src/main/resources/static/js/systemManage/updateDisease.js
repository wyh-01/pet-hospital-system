/**
 * Created by wyh on 2023/3/22.
 */

'use strict';

var updateDisease = {};

updateDisease.initSectionCell = function (diseaseEntity) {
    var image = "<div id='diseaseImage'>" +
        "<img src=" + diseaseEntity.image +
        " style='width:100px;height:100px'/>" +
        "</div>";

    var name = "<div id='diseaseName'>" +
        "<p>" + diseaseEntity.name + "</p>" +
        "</div>";

    var id = "<div id='diseaseId' style='display:none'>" +
        diseaseEntity.id +
        "</div>";

    var button = "<div> <button onclick=\"updateDisease.update(" + diseaseEntity.id + ")\" type=\"button\" class=\"btn btn-primary btn-xs\">编辑</button>" +
        "<button onclick=\"updateDisease.delete(" + diseaseEntity.id + ")\" type=\"button\" class=\"btn btn-danger btn-xs\">删除</button></div>";

    var cell = "<div>" + image + name + button + id + "</div>";

    return cell;
};

updateDisease.initSection = function (diseaseList) {
    var section = "";
    for (var i = 0; i < diseaseList.length; i++) {
        section = section + updateDisease.initSectionCell(diseaseList[i]);
    }
    return section;
};

updateDisease.update = function (id){
    window.location.href = "../updateDisease/" + id;
}

updateDisease.delete = function (id){
    var fd = new FormData();
    fd.append("id", id);
    $.ajax({
        contentType : false,
        type: "POST",//方法类型
        processData: false,
        // dataType: "multipart/form-data",//预期服务器返回的数据类型
        url: "/api/disease/delete" ,//url
        data:fd,
        statusCode : {
            200: function(result){
                alert(result);
                window.location.href = "../diseaseManage";
            },
            400: function(result){
                alert(result.responseText);
                window.location.href = "../diseaseManage";
            }
        }
    });
}

updateDisease.bindSection = function () {
    $(".case-submenu>div").on('click', function () {
        var id = $(this).find("#diseaseId").html();
        console.log(id);
        window.location.href = "../updateDisease/" + id;
    });
}

updateDisease.initPage = function (res) {
    $("#section-shape-1>div").html(updateDisease.initSection(res.one));
    $("#section-shape-2>div").html(updateDisease.initSection(res.two));
    $("#section-shape-3>div").html(updateDisease.initSection(res.three));
    $("#section-shape-4>div").html(updateDisease.initSection(res.four));
    // updateDisease.bindSection();
};

updateDisease.init = function () {
    var req = {};
    comm.utils.postForm("/disease/all", req, updateDisease.initPage);
};