package com.kenny.demo.transactionaldemo.service;

import com.kenny.demo.transactionaldemo.common.code.ErrorInfo;
import com.kenny.demo.transactionaldemo.common.exception.TransactionalDemoException;
import com.kenny.demo.transactionaldemo.domain.Account;
import com.kenny.demo.transactionaldemo.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Slf4j
@RequiredArgsConstructor
@Service
public class AccountService {

    // (리팩토링) 고수준모듈이 저수준모듈을 직접 참조하고 있으므로 수정 필요
    private final AccountRepository accountRepository;

    /**
     * 이체 메서드
     */
    public Account transfer( final String withdrawAccountNo, final String depositBankCode, final String depositAccountNo, final String withdrawAmount) {

        final Account account = accountRepository.findById(withdrawAccountNo)
                .orElseThrow(() -> new TransactionalDemoException(ErrorInfo.NOT_EXSIT_ACCOUNT_NO));

        account.withdraw(new BigDecimal(withdrawAmount));

        return account;
    }
}
