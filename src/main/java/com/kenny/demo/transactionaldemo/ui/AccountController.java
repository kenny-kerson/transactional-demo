package com.kenny.demo.transactionaldemo.ui;

import com.kenny.demo.transactionaldemo.common.dto.CommonRequest;
import com.kenny.demo.transactionaldemo.common.dto.CommonResponse;
import com.kenny.demo.transactionaldemo.common.exception.TransactionalDemoException;
import com.kenny.demo.transactionaldemo.domain.Account;
import com.kenny.demo.transactionaldemo.service.AccountService;
import com.kenny.demo.transactionaldemo.ui.dto.TransferDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class AccountController {

    private final AccountService accountService;

    @PostMapping("/transfer")
    public CommonResponse<TransferDto.Out> transfer(@RequestBody final CommonRequest<TransferDto.In> input) {

        final Account account = accountService.transfer(input.getBody().getWithdrawAccountNo()
                , input.getBody().getDepositBankCode()
                , input.getBody().getDepositAccountNo()
                , input.getBody().getWithdrawAmount()
        );

        return CommonResponse.<TransferDto.Out> builder()
                .status("OK")
                .errorCode("TBD")
                .errorMessage("TBD")
                .customerNo(input.getCustomerNo())
                .guid(input.getGuid())
                .body(
                        TransferDto.Out.builder()
                                .withdrawAccountNo(input.getBody().getWithdrawAccountNo())
                                .withdrawAmount(input.getBody().getWithdrawAmount())
                                .depositBankCode(input.getBody().getDepositBankCode())
                                .depositAccountNo(input.getBody().getDepositAccountNo())
                                .withdrawAccountBalance(account.getAmount().toString())
                                .depositCustomerName("TBD")
                                .build()
                )
                .build()
        ;
    }
}
