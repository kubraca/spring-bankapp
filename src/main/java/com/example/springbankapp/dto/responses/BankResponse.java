package com.example.springbankapp.dto.responses;

import com.example.springbankapp.dto.requests.CustomerRequest;
import com.example.springbankapp.entity.Bank;
import com.example.springbankapp.entity.Customer;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Builder

public class BankResponse {

        @NotNull
        private long bankId;
        @NotBlank
        private String name;
        private List<Customer> customerRequestList;

        public Bank convertToBank(){
            return Bank.builder()
                    .bankName(name)
                    .id(bankId)
                    .customerList(customerRequestList)
                    .build();
        }
    }

