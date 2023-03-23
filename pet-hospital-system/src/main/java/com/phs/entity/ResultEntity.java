package com.phs.entity;

/**
 * Created by wyh on 2023/3/22
 */
public class ResultEntity {

    private Integer resultCode;
    private String resultMessage;

    public static final Integer successCode = 0;
    public static final Integer errorCode = 1;

    public ResultEntity(Integer resultCode, String resultMessage){
        this.resultCode = resultCode;
        this.resultMessage = resultMessage;
    }

    public ResultEntity(){}

    public Integer getResultCode() {
        return resultCode;
    }

    public void setResultCode(Integer resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }

    public static ResultEntity success(Integer code, String message){
        return new ResultEntity(code, message);
    }

    public static ResultEntity success(String message){
        return ResultEntity.success(successCode, message);
    }

    public static ResultEntity success(){
        return ResultEntity.success("操作成功");
    }

    public static ResultEntity error(Integer code, String message){
        return new ResultEntity(code, message);
    }

    public static ResultEntity error(String message){
        return ResultEntity.error(errorCode, message);
    }

    public static ResultEntity error(){
        return ResultEntity.error("操作失败");
    }
}
