package com.example.springbankapp.controller;

import com.example.springbankapp.dto.requests.BankRequest;
import com.example.springbankapp.entity.Bank;
import com.example.springbankapp.service.impl.BankServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
@RestController
@RequestMapping("/banks")
@RequiredArgsConstructor
public class BankController {
    private final BankServiceImpl bankService;

    @GetMapping("/findById/{id}")
    public Optional<Bank> getBank(@PathVariable Long id){// BankRequest döndürüp bodyde bankrequestteki bilgiler olmalı
            var bank=  bankService.findById(id);
            return Optional.of(bank.get());
    }
    @GetMapping("/findAll")
    public <List> java.util.List<Bank> getAllBank(){
        return bankService.findAll();
    }
    @PostMapping("/addBank")
    public Bank addBank(@RequestBody BankRequest request){
        Bank bank=request.convertToBank();
        return bankService.save(bank);
    }

    @PostMapping("/delete/{id}")
    public void deleteBank(@PathVariable Long id){
         bankService.deleteBank(id);
    }
    @PutMapping("/updateAll/{id}")
    public Optional<Bank> updateBank(@PathVariable Long id,
                                     @RequestBody BankRequest bankRequest){
        Optional<Bank> bank=bankService.findById(id);
        bank.get().setBankName(bankRequest.getName());
        return bank;

    }
}
