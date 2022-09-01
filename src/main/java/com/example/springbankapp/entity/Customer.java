package com.example.springbankapp.entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
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
@Builder
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, name = "cust_name")
    private String name;

    @Column(length = 100, name = "lastname")
    private String lastName;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @Access(AccessType.PROPERTY)
    @JoinColumn(name = "customer_account_id")
    private List<Account> accountList;
   // cascade = CascadeType.ALL,
}
