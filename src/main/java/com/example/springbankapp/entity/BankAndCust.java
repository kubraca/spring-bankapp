package com.example.springbankapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "bank_and_cust")
@NoArgsConstructor
@AllArgsConstructor
public class BankAndCust {
    @Id
    private Long id;


}
