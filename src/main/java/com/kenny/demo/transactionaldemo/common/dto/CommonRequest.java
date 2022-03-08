package com.kenny.demo.transactionaldemo.common.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@Getter
@ToString
public class CommonRequest<T> {

    private final String customerNo;
    private final String guid;
    private final T body;
}
