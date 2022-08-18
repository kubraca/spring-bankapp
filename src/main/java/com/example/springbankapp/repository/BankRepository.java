package com.example.springbankapp.repository;

import com.example.springbankapp.entity.Bank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  BankRepository extends JpaRepository<Bank,Long> {
}
