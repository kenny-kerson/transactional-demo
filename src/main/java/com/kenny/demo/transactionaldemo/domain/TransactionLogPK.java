package com.kenny.demo.transactionaldemo.domain;

import lombok.Getter;

import java.io.Serializable;

public class TransactionLogPK implements Serializable {

    private String customerNo;
    private String txDt;
    private String sequenceNo;
}
