package com.kosign.easy_cart.payload.product;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.kosign.easy_cart.entity.Photo;
import com.kosign.easy_cart.payload.photo.PhotoRequest;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ProductRequest {

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

    List<Photo> photo;
}
