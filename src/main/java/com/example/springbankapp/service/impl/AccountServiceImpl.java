package com.example.springbankapp.service.impl;

import com.example.springbankapp.entity.Account;
import com.example.springbankapp.repository.AccountRepository;
import com.example.springbankapp.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
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
        if(senderAcc.getBalance()>0){
            senderAcc.setBalance(senderAcc.getBalance()-amount);
            recieverAcc.setBalance(recieverAcc.getBalance()+amount);
            this.accountRepository.saveAndFlush(senderAcc);
            this.accountRepository.saveAndFlush(recieverAcc);
        }
        else if(senderAcc.getBalance()<=0){
            log.info("Yeterli bakiyeniz bulunmamaktadır.",amount,senderAcc.getBalance());
        }

    }
    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }
    @Override
    public Optional<Account> findById(Long id) {
        return accountRepository.findById(id);
    }

    @Override
    public void deleteAccount(Long id) {
        accountRepository.deleteById(id);
    }
}
