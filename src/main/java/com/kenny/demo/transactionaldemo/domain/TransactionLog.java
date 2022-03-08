package com.kenny.demo.transactionaldemo.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;


@Getter @ToString
@Builder
@NoArgsConstructor @AllArgsConstructor
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
