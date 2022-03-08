package com.kenny.demo.transactionaldemo.common.aspect.advice;

import com.kenny.demo.transactionaldemo.common.dto.CommonResponse;
import com.kenny.demo.transactionaldemo.common.exception.TransactionalDemoException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class TransactionalDemoExceptionHandler {


    @ExceptionHandler({TransactionalDemoException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public CommonResponse<?> defaultExceptionHandler(final TransactionalDemoException e) {
        log.debug( "__KENNY__ defaultExceptionHandler : ", e );

        return CommonResponse.builder()
                .status("ERROR")
                .errorCode(e.getErrorCode())
                .errorMessage(e.getErrorMessage())
                .customerNo("Request Header에 넣어야 함")
                .guid("Request Header에 넣어야 함")
                .build();
    }
}
