package com.example.springbankapp.service;

import com.example.springbankapp.entity.Bank;
import com.example.springbankapp.entity.Customer;

import java.util.List;
import java.util.Optional;

public interface BankService {
    public Optional<Bank> findById(Long id);

    Bank save(Bank bank);

    void addCustomer(Bank bank, Customer customer);

    List<Bank> findAll();
}
