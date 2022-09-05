package com.example.springbankapp.controller;

import com.example.springbankapp.entity.Account;
import com.example.springbankapp.entity.Bank;
import com.example.springbankapp.service.impl.AccountServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/accounts")
@RequiredArgsConstructor
public class AccountController {
    private final AccountServiceImpl accountService;

    @PostMapping("/addAccount")
    public Account add(@RequestBody Account account){
        return accountService.add(account);

    }
    @PostMapping("/sendMoney")
    public void sendMoney( Long senderId, Long recieverId,
                          double amount) {
        accountService.sendMoney(senderId,recieverId,amount);
    }
    @PostMapping("/accumulationMoney")
    public double accumulationMoney( Long depositAccId, int day, double amount){
        return accountService.accumulationMoney(depositAccId, day,amount);
    }
    @PostMapping("/withdrawMoney")
    public void withdrawMoney( Long accountId, double drawMoney){
         accountService.withdrawMoney(accountId,drawMoney);
    }
    @GetMapping("/findById/{id}")
    public Optional<Account> findById(@PathVariable Long id){
       return accountService.findById(id);
    }
    @GetMapping("/findAllId")
    public <List> java.util.List<Account> getAllAccount(){
        return accountService.findAll();
    }
    @PostMapping("/delete/{id}")
    public void deleteAccount(@PathVariable Long id){
        accountService.deleteAccount(id);
    }

}
