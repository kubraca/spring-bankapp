package com.example.springbankapp.dto.requests;

import com.example.springbankapp.entity.Account;
import com.example.springbankapp.entity.Bank;
import com.example.springbankapp.entity.Customer;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
public class CustomerRequest {

    @NotBlank
    private String name;
    @NotNull
    private List<Account> accountRequestList;

    public Customer convertToCustomer() {
        return Customer.builder()
                .name(name)
                .accountList(accountRequestList)
                .build();
    }
}
