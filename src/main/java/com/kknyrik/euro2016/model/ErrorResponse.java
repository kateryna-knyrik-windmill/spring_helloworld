package com.kknyrik.euro2016.model;

public class ErrorResponse {

    private String errorCode;

    public ErrorResponse() {
    }

    public ErrorResponse(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
}
