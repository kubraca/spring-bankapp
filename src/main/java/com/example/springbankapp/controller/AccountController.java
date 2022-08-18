package com.example.springbankapp.controller;

import com.example.springbankapp.entity.Account;
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
    @GetMapping("/findById/{id}")
    public Optional<Account> findById(@PathVariable Long id){
       return accountService.findById(id);
    }
}
