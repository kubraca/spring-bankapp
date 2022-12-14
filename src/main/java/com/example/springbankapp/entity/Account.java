package com.example.springbankapp.entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
@Data
@Entity
@Table(name = "accounts")
@NoArgsConstructor
@AllArgsConstructor
@DynamicUpdate
@Builder
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountID;
    @Column(length = 100, name = "acc_type")
    private String accountType;
    @Column(name = "balance")
    private double balance;
    @Column(name="accumulationrate")
    private double rate;

}
