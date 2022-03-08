package com.kenny.demo.transactionaldemo.common.exception;

public class TransactionalDemoException extends RuntimeException {

    private final String errorCode;
    private final String errorMessage;

    public TransactionalDemoException( final String errorCode, final String errorMessage) {
        super(errorMessage);
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public TransactionalDemoException( final String errorCode, final String errorMessage, final Throwable e) {
        super(errorMessage, e);
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
}
