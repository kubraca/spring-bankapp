package com.example.springbankapp.service;

import com.example.springbankapp.entity.Account;
import com.example.springbankapp.entity.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {

    Optional<Customer> findById(Long id);

    Customer add(Customer customer);

    Account addAcc(Customer customer, Account account);

    List<Customer> findAll();
}
