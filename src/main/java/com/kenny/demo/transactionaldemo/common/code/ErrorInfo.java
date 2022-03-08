package com.kenny.demo.transactionaldemo.common.code;

public enum ErrorInfo {

    NOT_EXSIT_ACCOUNT_NO("B00001", "계좌번호가 존재하지 않습니다"),
    ;

    private final String errorCode;
    private final String errorMessage;

    ErrorInfo(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
