package com.example.springbankapp.service.impl;
import com.example.springbankapp.dto.requests.CustomerRequest;
import com.example.springbankapp.entity.Account;
import com.example.springbankapp.entity.Customer;
import com.example.springbankapp.repository.AccountRepository;
import com.example.springbankapp.repository.BankRepository;
import com.example.springbankapp.repository.CustomerRepository;
import com.example.springbankapp.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

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
    public Customer add(CustomerRequest request) {
        return customerRepository.save(request.convertToCustomer());

    }


    @Override
    public Account addAccount(Long id, Account account){
        Customer cust= customerRepository.findById(id).orElseThrow();
        cust.getAccountList().add(account);
        customerRepository.saveAndFlush(cust);
        return account;
    }
    @Override
    public Customer updateCustomerInfo(Long id, CustomerRequest customerRequest){
        var customer=customerRepository.findById(id).orElseThrow(() -> new NotFoundException("id bulunamadı"));
        customer.setName(customerRequest.getName());
        customerRepository.save(customer);
        return customer;
    }
    @Override
    public List<Customer> findAll(){
        return customerRepository.findAll();
    }


    @Override
    public void deleteCustomerById(Long id){
        customerRepository.deleteById(id);


    }
}


