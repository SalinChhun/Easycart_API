package com.kosign.easy_cart.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "product_tb")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String title;

    private String description;

    private BigDecimal price;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private BigDecimal totalAmount;

    private String status;

    private BigDecimal discountPrice;

    private Boolean discountType;

    private LocalDateTime createdDate;

    private String condition;

    private String brand;

    private String model;

    private String color;

    private String year;

    private String size;

    private String type;

    private Boolean isHidden;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    List<Photo> photos;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    List<Bookmark> bookmarks;

    @OneToMany(mappedBy = "product")
    List<Purchase> purchases;


    @Builder
    public Product(User user,
                   String title,
                   String description,
                   String status,
                   BigDecimal price,
                   BigDecimal discountPrice,
                   BigDecimal totalAmount,
                   Boolean discountType,
                   LocalDateTime createdDate,
                   String condition,
                   String brand,
                   String model,
                   String color,
                   String year,
                   String size,
                   String type,
                   Boolean isHidden,
                   List<Photo> photos,
                   Category category) {
        this.user = user;
        this.title = title;
        this.description = description;
        this.status = status;
        this.price = price;
        this.totalAmount = totalAmount;
        this.discountPrice = discountPrice;
        this.discountType = discountType;
        this.createdDate = createdDate;
        this.condition = condition;
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.year = year;
        this.size = size;
        this.type = type;
        this.isHidden = isHidden;
        this.photos = photos;
        this.category = category;
    }
}
