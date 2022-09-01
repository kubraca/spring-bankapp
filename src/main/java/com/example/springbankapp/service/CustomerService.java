package com.example.springbankapp.service;

import com.example.springbankapp.dto.requests.CustomerRequest;
import com.example.springbankapp.entity.Account;
import com.example.springbankapp.entity.Bank;
import com.example.springbankapp.entity.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {

    Optional<Customer> findById(Long id);

    Customer add(CustomerRequest request);

    Account addAccount(Long id, Account account);

    Customer updateCustomerInfo(Long id, CustomerRequest customerRequest);

    List<Customer> findAll();

    void deleteCustomerById(Long id);
}
