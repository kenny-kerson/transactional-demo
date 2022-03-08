package com.kenny.demo.transactionaldemo.ui;

import com.kenny.demo.transactionaldemo.common.dto.CommonRequest;
import com.kenny.demo.transactionaldemo.common.dto.CommonResponse;
import com.kenny.demo.transactionaldemo.ui.dto.TransferDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @PostMapping("/transfer")
    public CommonResponse<TransferDto.Out> transfer(@RequestBody final CommonRequest<TransferDto.In> input) {

        return CommonResponse.<TransferDto.Out> builder()
                .status("TBD")
                .errorCode("TBD")
                .errorMessage("TBD")
                .customerNo(input.getCustomerNo())
                .guid(input.getGuid())
                .body(
                        TransferDto.Out.builder()
                                .depositBankCode(input.getBody().getDepositBankCode())
                                .depositAccountNo(input.getBody().getDepositAccountNo())
                                .withdrawAmount(input.getBody().getWithdrawAmount())
                                .depositCustomerName("TBD")
                                .build()
                )
                .build()
        ;
    }
}
