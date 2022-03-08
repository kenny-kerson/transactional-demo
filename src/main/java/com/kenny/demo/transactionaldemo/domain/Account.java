package com.kenny.demo.transactionaldemo.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@ToString
@Getter
@Entity
public class Account {

    @Id
    private String accountNo;
    private BigDecimal amount;
    private String status;
    private String customerNo;
    private String changeDate;
    private String changeTime;

    public void withdraw(final BigDecimal amount) {
        this.amount = this.amount.add(amount.negate());
    }
}
