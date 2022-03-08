package com.kenny.demo.transactionaldemo.common.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@Builder
@Getter
@ToString
public class CommonResponse<T> {

    private final String status;
    private final String errorCode;
    private final String errorMessage;
    private final String customerNo;
    private final String guid;
    private final T body;
}
