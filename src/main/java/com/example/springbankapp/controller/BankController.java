package com.example.springbankapp.controller;

import com.example.springbankapp.entity.Bank;
import com.example.springbankapp.service.impl.BankServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/banks")
@RequiredArgsConstructor
public class BankController {
    private final BankServiceImpl bankService;

    @GetMapping("/findById/{id}")
    public Optional<Bank> getBank(@PathVariable Long id){

        return bankService.findById(id);
    }
    @GetMapping("/findAllId")
    public <List>Bank getAllBank(){
        return (Bank) bankService.findAll();
    }
    @PostMapping("/addBank")
    public Bank addBank(@RequestBody  Bank bank){
        return bankService.save(bank);
    }

    @PostMapping("/delete/{id}")
    public void deleteBank(@PathVariable Long id){
         bankService.deleteBank(id);
    }

}
