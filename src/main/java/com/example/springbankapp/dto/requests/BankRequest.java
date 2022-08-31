package com.example.springbankapp.dto.requests;

import com.example.springbankapp.entity.Bank;
import com.example.springbankapp.entity.Customer;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
public class BankRequest {
         @NotNull
         private long bankId;
        @NotBlank
        private String name;

       // @NotNull
        //private List<Customer> customerRequestList;

        public Bank convertToBank(){
            return Bank.builder()
                    .bankName(name)
                    .id(bankId)
                   // .customerList(customerRequestList)
                            .build();
        }
    }

