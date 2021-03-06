package com.yjx.entity;

public class Result {

    private int code;

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Result(String message){this.message=message;}

    public Result(int code) {
        this.code = code;
    }

    public Result(int code,String message){
        this.code=code;
        this.message=message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}