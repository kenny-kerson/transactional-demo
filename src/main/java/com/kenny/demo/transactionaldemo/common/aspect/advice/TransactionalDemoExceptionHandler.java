package com.kenny.demo.transactionaldemo.common.aspect.advice;

import com.kenny.demo.transactionaldemo.common.dto.CommonResponse;
import com.kenny.demo.transactionaldemo.common.exception.TransactionalDemoException;
import com.kenny.demo.transactionaldemo.domain.TransactionLog;
import com.kenny.demo.transactionaldemo.repository.TransactionLogRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@RestControllerAdvice
public class TransactionalDemoExceptionHandler {

    // (리팩토링) 고수준모듈이 저수준모듈을 직접 참조하고 있으므로 수정 필요
    private final TransactionLogRepository transactionLogRepository;

    @ExceptionHandler({TransactionalDemoException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public CommonResponse<?> defaultExceptionHandler(final TransactionalDemoException e) {
        log.debug( "__KENNY__ defaultExceptionHandler : ", e );

        // 컨트롤러 트랜잭션과 무관하게 거래로그 INSERT
        transactionLogRepository.save(
                TransactionLog.builder()
                        .customerNo("11000000339")
                        .txDt("20220308")
                        // (리팩토링) psql 시퀀스 로직으로 변경 필요
                        .sequenceNo(UUID.randomUUID().toString())
                        .status("ERROR")
                        .input("TBD")
                        .output("TBD")
                        .txTime("TBD")
                        .guid("TBD")
                        .build()
        );

        return CommonResponse.builder()
                .status("ERROR")
                .errorCode(e.getErrorCode())
                .errorMessage(e.getErrorMessage())
                .customerNo("Request Header에 넣어야 함")
                .guid("Request Header에 넣어야 함")
                .build();
    }
}
