package com.example.springbankapp.entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
// entityleri domain olarak apiye acmayız cunku burada yapılan
//değişiklik apide değişsin istemeyiz Dtoyu bilmelerini isterizüzerinden işlemler yapılsın isteriz.
@Table(name = "banks")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Bank implements Serializable {
// Jpa entityleri Serialization interfaceinden gelir yani
// entityini ilişkisel veritabanında primary keyi olmalı ve bu keyin tabloda herhangi bir fielda atanmış olması gerekiyor
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 100, name="bank_name")
    private String bankName;
    @Column(length = 100, name = "interestRate")
    private double dailyInterestRate;
    @Column(length = 100, name = "accRate")
    private double accumulationRate;
    @OneToMany()
    @JoinColumn(name = "banksCustomerList")
    private List<Customer> customerList;
}
//cascade = CascadeType.ALL