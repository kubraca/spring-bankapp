package com.example.springbankapp.service;

import com.example.springbankapp.entity.Account;

import java.util.List;
import java.util.Optional;

public interface AccountService {
    Account add(Account account);

    void sendMoney(Long senderAccId, Long recieverAcc, double amount);

    double accumulationMoney(Long depositAccID, int day, double money);

    List<Account> findAll();
    Optional<Account> findById(Long id);

    void deleteAccount(Long id);
}
