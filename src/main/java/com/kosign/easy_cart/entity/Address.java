package com.kosign.easy_cart.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "delivery_address_tb")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String label;

    private String contact;

    private String tel;

    private String address;

    private String detail;

    private String remark;

    @OneToMany(mappedBy = "address", cascade = CascadeType.ALL)
    List<Purchase> purchases;

    @Builder
    public Address(Long id,
                   User user,
                   String label,
                   String contact,
                   String tel,
                   String address,
                   String detail,
                   String remark,
                   List<Purchase> purchases
    ) {
        this.id = id;
        this.user = user;
        this.label = label;
        this.contact = contact;
        this.tel = tel;
        this.address = address;
        this.detail = detail;
        this.remark = remark;
        this.purchases = purchases;
    }
}
