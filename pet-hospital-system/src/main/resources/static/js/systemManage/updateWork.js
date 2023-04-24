/**
 * Created by wyh on 2023/3/22.
 */

'use strict';

var updateWork = {};

updateWork.generateWork = function (res) {
    var html = "";
    if(res&&res.length>0){
        for(var i=0;i<res.length;i++){
            html =  html +
                "<li> " +
                "<p>" + res[i].name + "</p> " +
                "<div> <button onclick=\"updateWork.update(" + res[i].id + ")\" type=\"button\" class=\"btn btn-primary btn-xs\">编辑</button>" +
                "<button onclick=\"updateWork.delete(" + res[i].id +"," + res[i].job_id + ")\" type=\"button\" class=\"btn btn-danger btn-xs\">删除</button></div>" +
                "<p>" + res[i].description + "</p>" +
                "<video width=\"960\" height=\"600\" controls=\"autoplay\">" +
                "<source src=\"" + res[i].video_url +
                "\" type=\"video/mp4\"/> </video>" +
                "</li> " +
                "<hr />"
        }
        $(".work-list").html(html);
    }
};

updateWork.update = function (id){
    window.location.href = "../updateWork/" + id;
}

updateWork.delete = function (workId, jobId){
    var fd = new FormData();
    fd.append("id", workId);
    $.ajax({
        contentType : false,
        type: "POST",//方法类型
        processData: false,
        // dataType: "multipart/form-data",//预期服务器返回的数据类型
        url: "/api/work/delete" ,//url
        data:fd,
        statusCode : {
            200: function(result){
                alert(result);
                if(jobId == 1){
                    window.location.href = "../workManage/doctor";
                }else if(jobId == 2){
                    window.location.href = "../workManage/assistant";
                }else if(jobId == 3) {
                    window.location.href = "../workManage/receptionist";
                }
            },
            400: function(result){
                alert(result.responseText);
                if(jobId == 1){
                    window.location.href = "../workManage/doctor";
                }else if(jobId == 2){
                    window.location.href = "../workManage/assistant";
                }else if(jobId == 3) {
                    window.location.href = "../workManage/receptionist";
                }
            }
        }
    });
}


updateWork.getJobId = function () {
    var jobName = $.getUrlLastParam();
    if(jobName==="doctor")
        return 1;
    else if(jobName==="assistant")
        return 2;
    else
        return 3;
};

updateWork.init = function () {
    var jobId = updateWork.getJobId();
    var req = {
        jobId:jobId
    };
    comm.utils.postForm("/work/detail",req,updateWork.generateWork);
};