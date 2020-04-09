package com.ruanmou.house.housecommon.common;


/**
 * 订制api响应类
 */
public class ApiResponse {


    private int code; // 状态码
    private String message; // 消息
    private Object data; // 返回数据

    /**
     *  定义常用静态方法
     */
    public static ApiResponse ofSuccess(Object data){
        return new ApiResponse(Status.SUCCESS.getCode(),Status.SUCCESS.getStandardMessage(),data);
    }

    public static ApiResponse ofMessage(int code,String message){
        return new ApiResponse(code,message,null);
    }

    public static ApiResponse ofStatus(Status status){
        return new ApiResponse(status.getCode(),status.getStandardMessage(),null);
    }










    public ApiResponse(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    // 状态枚举
    public enum Status{
        SUCCESS(200,"OK"),
        BAD_REQUESE(400,"Bad Request"),
        NOT_FOUND(404,"page not found"),
        INTERNAL_SERVER_ERROR(500,"server internal error"),
        NOT_LOGIN(40005,"not login"),
        INVALID_PARAM(40006,"invalid parameter");

        private int code;
        private String standardMessage;

        private Status(int code, String standardMessage) {
            this.code = code;
            this.standardMessage = standardMessage;
        }

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getStandardMessage() {
            return standardMessage;
        }

        public void setStandardMessage(String standardMessage) {
            this.standardMessage = standardMessage;
        }
    }
}
