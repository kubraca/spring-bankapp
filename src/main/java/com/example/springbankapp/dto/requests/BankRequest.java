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

        @NotBlank
        private String name;

        public Bank convertToBank(){
            return Bank.builder()
                    .bankName(name)
                            .build();
        }
    }

