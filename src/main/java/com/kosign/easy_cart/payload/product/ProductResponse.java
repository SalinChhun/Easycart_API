package com.kosign.easy_cart.payload.product;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.kosign.easy_cart.entity.Photo;
import com.kosign.easy_cart.entity.User;
import com.kosign.easy_cart.payload.photo.PhotoResponse;
import com.kosign.easy_cart.payload.user.UserResponse;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ProductResponse {

    private Long id;

    private String title;

    private String description;

    private BigDecimal price;

    private BigDecimal discountPrice;

    private Boolean discountType;

    private String condition;

    private String brand;

    private String model;

    private String color;

    private String year;

    private String size;

    private String type;

    private Boolean isHidden;

    private String status;

    private LocalDateTime createdDate;;

    List<PhotoResponse> photo;

    UserResponse user;

    @Builder
    public ProductResponse(Long id,
                           String title,
                           String description,
                           String status,
                           BigDecimal price,
                           BigDecimal discountPrice,
                           Boolean discountType,
                           String condition,
                           String brand,
                           String model,
                           String color,
                           String year,
                           String size,
                           String type,
                           Boolean isHidden,
                           LocalDateTime createdDate,
                           List<PhotoResponse> photo,
                           UserResponse user
    ) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.price = price;
        this.discountPrice = discountPrice;
        this.discountType = discountType;
        this.condition = condition;
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.year = year;
        this.size = size;
        this.type = type;
        this.isHidden = isHidden;
        this.createdDate = createdDate;
        this.photo = photo;
        this.user = user;
        this.status = status;
    }
}
