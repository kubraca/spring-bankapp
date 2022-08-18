package com.example.springbankapp.service;

import com.example.springbankapp.entity.Bank;

import java.util.Optional;

public interface BankService {
    public Optional<Bank> findById(Long id);
}
