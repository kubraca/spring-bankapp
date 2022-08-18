package com.example.springbankapp.dto;

import com.example.springbankapp.entity.Account;
import com.example.springbankapp.entity.Bank;
import lombok.Data;

import javax.persistence.Column;
import java.util.List;
@Data
public class CustomerDto {
    private Long id;
    private String name;
    private String lastName;
    private List<Account> accountList;
}
