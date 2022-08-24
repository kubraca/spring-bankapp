package com.example.springbankapp.dto.requests;

import com.example.springbankapp.entity.Account;
import com.example.springbankapp.entity.Customer;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class AccountRequest {
    @NotBlank
    private String name;
    @NotNull
    private double balance;

    public Account convertToAccount() {
        return Account.builder()
                .balance(balance)
                .build();
    }
}