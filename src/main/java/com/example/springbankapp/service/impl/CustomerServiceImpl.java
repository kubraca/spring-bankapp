package com.example.springbankapp.service.impl;
import com.example.springbankapp.entity.Account;
import com.example.springbankapp.entity.Bank;
import com.example.springbankapp.entity.Customer;
import com.example.springbankapp.repository.AccountRepository;
import com.example.springbankapp.repository.BankRepository;
import com.example.springbankapp.repository.CustomerRepository;
import com.example.springbankapp.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final AccountRepository accountRepository;
    private final BankRepository bankRepository;
    @Override
    public Optional<Customer> findById(Long id) {
        return customerRepository.findById(id);
    }

    @Override
    public Customer add(Customer customer) {
        return customerRepository.save(customer);

    }
    @Override
    public Account addAcc(Customer customer, Account account){
        //var cust= customerRepository.findById(customer.getId());
        customer.setAccountList((List<Account>) account);
        customerRepository.saveAndFlush(customer);
        return account;
    }
    @Override
    public List<Customer> findAll(){
        return customerRepository.findAll();
    }

}
