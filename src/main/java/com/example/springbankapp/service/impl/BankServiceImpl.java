package com.example.springbankapp.service.impl;

import com.example.springbankapp.entity.Bank;
import com.example.springbankapp.repository.BankRepository;
import com.example.springbankapp.service.BankService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BankServiceImpl implements BankService {

    private final BankRepository bankRepository;
    @Override
    public Optional<Bank> findById(Long id) {
        return bankRepository.findById(id);
    }

    public Bank save(Bank bank) {
       return bankRepository.save(bank);
    }
}
