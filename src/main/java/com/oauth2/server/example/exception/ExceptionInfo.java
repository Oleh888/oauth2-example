package com.oauth2.server.example.exception;

public class ExceptionInfo {

    private String errorMsg;

    public ExceptionInfo() {

    }

    public ExceptionInfo(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
