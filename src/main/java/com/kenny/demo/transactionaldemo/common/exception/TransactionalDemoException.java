package com.kenny.demo.transactionaldemo.common.exception;

import com.kenny.demo.transactionaldemo.common.code.ErrorInfo;
import lombok.Getter;

@Getter
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

    public TransactionalDemoException(final ErrorInfo errorInfo ) {
        super(errorInfo.getErrorMessage());
        this.errorCode = errorInfo.getErrorCode();
        this.errorMessage = errorInfo.getErrorMessage();
    }

    public TransactionalDemoException(final ErrorInfo errorInfo, final Throwable e ) {
        super(errorInfo.getErrorMessage(), e);
        this.errorCode = errorInfo.getErrorCode();
        this.errorMessage = errorInfo.getErrorMessage();
    }
}
