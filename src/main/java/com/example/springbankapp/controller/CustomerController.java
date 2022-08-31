package com.example.springbankapp.controller;

import com.example.springbankapp.dto.requests.CustomerRequest;
import com.example.springbankapp.entity.Account;
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

    @PostMapping("/addCustomer")
    public Customer add(@RequestBody CustomerRequest request){
       return customerService.add(request.convertToCustomer());

    }
    @GetMapping("/findByID")
    public Optional<Customer> findJustOne (Long id){
        return customerService.findById(id);
    }
    @PostMapping("/addAccount")
    public Account addAccount(@RequestBody CustomerRequest request,Account account){
        return customerService.addAccount(request.convertToCustomer(),account);
    }
    @GetMapping("/findAllCust")
    public List<Customer> findAllCust(){
        return customerService.findAll();
    }
    @PutMapping("/{id}/updateAll")
    public Customer updateCustomer(@PathVariable Long id, @RequestBody  CustomerRequest request){
        return customerService.updateCustomerInfo(id, request);

    }
    @PostMapping("/deleteById/{id}")
    public void deleteCustomerById(@PathVariable Long id){
        customerService.deleteCustomerById(id);
    }



}
