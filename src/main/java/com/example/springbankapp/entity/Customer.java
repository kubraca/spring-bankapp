package com.example.springbankapp.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Fetch;
import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "customers")
@NoArgsConstructor
@AllArgsConstructor
@DynamicUpdate
public class Customer {
    @Id
    private Long id;
    @Column(length = 100, name = "cust_name")
    private String name;
    @Column(length = 100, name = "lastname")
    private String lastName;
    @Column(length = 100, name = "TC")
    private String TC;
    @OneToMany

    private List<Account> accountList;
    @ManyToOne
    @JoinColumn(name = "customer_of_banks")
    private Bank bank;

}
