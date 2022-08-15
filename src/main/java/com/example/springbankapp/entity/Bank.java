package com.example.springbankapp.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.io.Serializable;
@Data
@Entity
@Table(name = "banks_name")
@NoArgsConstructor
@AllArgsConstructor
public class Bank implements Serializable {
// Jpa entityleri Serialization interfaceinden gelir yani
// entityini ilişkisel veritabanında primary keyi olmalı ve bu keyin tabloda herhangi bir fielda atanmış olması gerekiyor
    @Id
    @GeneratedValue

    private String bankName;

    private double dailyInterestRate;

    private double accumulationRate;
}
