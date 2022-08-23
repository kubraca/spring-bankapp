package com.example.springbankapp.service.impl;

import com.example.springbankapp.entity.Bank;
import com.example.springbankapp.entity.Customer;
import com.example.springbankapp.repository.BankRepository;
import com.example.springbankapp.repository.CustomerRepository;
import com.example.springbankapp.service.BankService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BankServiceImpl implements BankService {

    private final BankRepository bankRepository;
    private final CustomerRepository customerRepository;
    @Override
    public Optional<Bank> findById(Long id) {
        return bankRepository.findById(id);
    }

    @Override
    public Bank save(Bank bank) {
       return bankRepository.save(bank);
    }
    @Override
    public void addCustomer(Bank bank, Customer customer){
        bank.setCustomerList((List<Customer>) customer);
        customerRepository.saveAndFlush(customer);
        System.out.println(customer+"müsterisini bankanıza eklediniz!"); ;
    }
    @Override
    public List<Bank> findAll(){
        return bankRepository.findAll();
    }

    public void deleteBank(Long id) {
        bankRepository.deleteById(id);
    }
}
