package com.kosign.easy_cart.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "purchase_detail_tb")
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "address_delivery_id")
    private Address address;

    @OneToOne
    @JoinColumn(name = "receipt_id")
    private Receipt receipt;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "payment_method")
    private String paymentMethod;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @Builder
    public Purchase(Long id,
                    User user,
                    Address address,
                    Receipt receipt,
                    Product product,
                    String paymentMethod,
                    LocalDateTime createdDate
    ) {
        this.id = id;
        this.user = user;
        this.address = address;
        this.receipt = receipt;
        this.product = product;
        this.paymentMethod = paymentMethod;
        this.createdDate = createdDate;
    }
}
