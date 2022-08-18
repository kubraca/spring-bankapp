package com.example.springbankapp.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BankDto {
    private Long id;
    private String bankName;
}
