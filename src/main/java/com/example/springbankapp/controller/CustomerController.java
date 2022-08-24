package com.example.springbankapp.controller;

import com.example.springbankapp.dto.requests.CustomerRequest;
import com.example.springbankapp.entity.Account;
import com.example.springbankapp.entity.Bank;
import com.example.springbankapp.entity.Customer;
import com.example.springbankapp.service.BankService;
import com.example.springbankapp.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.webjars.NotFoundException;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;
    private final BankService bankService;



    @PostMapping("/addCustomer")
    public Customer add(@RequestBody CustomerRequest request){
       return customerService.add(request.convertToCustomer());

    }
    @GetMapping("/findByID")
    public Optional<Customer> findJustOne (Long id){
        return customerService.findById(id);
    }
    @PostMapping("/addAccount")
    public Account addAcc(@RequestBody Account account, @RequestBody CustomerRequest request){
        return customerService.addAcc(request.convertToCustomer(),account);
    }
    @GetMapping("/findAllCust")
    public List<Customer> findAllCust(){
        return customerService.findAll();
    }
    @PutMapping("/{id}/updateAll")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @RequestBody  CustomerRequest request){
      var customer =customerService.findById(id).orElseThrow(() -> new NotFoundException("id bulunamadı"));
        customer.setName(request.getName());
        customerService.add(customer);
        return ResponseEntity.ok(customer);

    }



}
