package com.example.springbankapp.service.impl;

import com.example.springbankapp.entity.Account;
import com.example.springbankapp.repository.AccountRepository;
import com.example.springbankapp.service.AccountService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }
    @Override
    public Account add(Account account) {
        var added=  accountRepository.save(account);
        return added;
    }

    @Override
    public void sendMoney(Account senderAcc, Account recieverAcc, double amount) {

    }
   /* @Override
    public void sendMoney(Account senderAcc, Account recieverAcc, double amount){
        if(senderAcc.getBalance()>0){
            this.accountRepository.saveAndFlush();
        }
    }*/

    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }
    @Override
    public Optional<Account> findById(Long id) {
        return accountRepository.findById(id);
    }

}
