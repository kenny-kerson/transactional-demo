package com.kenny.demo.transactionaldemo.domain;

import lombok.Getter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@ToString
@Getter
@Entity
@IdClass(TransactionLogPK.class)
public class TransactionLog {

    @Id
    private String customerNo;
    @Id
    private String txDt;
    @Id
    private String sequenceNo;
    private String status;
    private String input;
    private String output;
    private String txTime;
    private String guid;
}
