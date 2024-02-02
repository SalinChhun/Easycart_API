//package com.kosign.easy_cart.entity;
//
//import jakarta.persistence.*;
//import lombok.Getter;
//import lombok.Setter;
//
//import java.util.List;
//
//@Entity
//@Getter
//@Setter
//@Table(name = "bank_tb")
//public class Bank {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @OneToMany(mappedBy = "bank")
//    List<User> users;
//
//    @Column(name = "bank_name")
//    private String name;
//
//    @Column(name = "account_name")
//    private String accountName;
//
//    @Column(name = "account_number")
//    private Integer accountNumber;
//
//    @Column(name = "bank_logo")
//    private String bankLogo;
//}
