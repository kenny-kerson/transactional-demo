package com.kenny.demo.transactionaldemo.ui.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

public class TransferDto {

    @Getter @ToString
    @Builder
    public static class In {
        private String withdrawAccountNo;
        private String withdrawAmount;
        private String depositBankCode;
        private String depositAccountNo;
    }

    @Getter @ToString
    @Builder
    public static class Out {
        private String depositBankCode;
        private String depositAccountNo;
        private String withdrawAmount;
        private String depositCustomerName;
    }
}
