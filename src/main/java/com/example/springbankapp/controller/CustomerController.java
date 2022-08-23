package com.example.springbankapp.controller;

import com.example.springbankapp.entity.Account;
import com.example.springbankapp.entity.Bank;
import com.example.springbankapp.entity.Customer;
import com.example.springbankapp.service.BankService;
import com.example.springbankapp.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;
    private final BankService bankService;


    @PostMapping("/addCustomer")
    public Customer add(@RequestBody Customer customer){
       return customerService.add(customer);

    }
    @GetMapping("/findByID")
    public Optional<Customer> findJustOne (Long id){
        return customerService.findById(id);
    }
    @PostMapping("/addAccount")
    public Account addAcc(@RequestBody Account account, @RequestBody Customer customer){
        return customerService.addAcc(customer,account);
    }
    @GetMapping("/findAllCust")
    public List<Customer> findAllCust(){
        return customerService.findAll();
    }



}
