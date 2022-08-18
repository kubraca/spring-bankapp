package com.example.springbankapp.dto;

import com.example.springbankapp.entity.Customer;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Data
@Builder
public class AccountDto {
    private Long accountID;
    private Customer customer;
}
