package com.kosign.easy_cart.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "photo_tb")
public class Photo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String photo;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Builder
    public Photo(String photo) {
        this.photo = photo;
    }
}
