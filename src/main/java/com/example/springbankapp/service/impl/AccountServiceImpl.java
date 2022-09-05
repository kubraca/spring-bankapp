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

    public void sendMoney(Long senderAccId, Long recieverAccId, double amount) {
        var senderAcc= accountRepository.findById(senderAccId);
        var recieverAcc= accountRepository.findById(recieverAccId);

        if(senderAcc.get().getBalance()>0){
            senderAcc.get().setBalance(senderAcc.get().getBalance()-amount);
            recieverAcc.get().setBalance(recieverAcc.get().getBalance()+amount);
            this.accountRepository.saveAndFlush(senderAcc.get());
            this.accountRepository.saveAndFlush(recieverAcc.get());
        }
        else if(senderAcc.get().getBalance()<=0){
            log.info("Yeterli bakiyeniz bulunmamaktadır.",amount,senderAcc.get().getBalance());
        }

    }
    public void withdrawMoney(Long accountId, double money){
        var account=accountRepository.findById(accountId);
        if (account.get().getBalance()>0){
            account.get().setBalance(account.get().getBalance()-money);
            this.accountRepository.saveAndFlush(account.get());
        } else
            log.info("Yeterli bakiyeniz bulunmamaktadır.",money,account.get().getBalance());
        }

    @Override
    public double accumulationMoney(Long depositAccId, int day, double money){
        var account=accountRepository.findById(depositAccId);
        if(account.get().getBalance()>0 && account.get().getAccountType().equals("vadeli")){
            long accumulated = (long) ((money * day * 0.15 * account.get().getRate()) / 36500.0);
           return accumulated;

        } else {
            return 0;
        } //log.info("Hesap türünüzü ve bakiyenizi kontrol ediniz.");

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
