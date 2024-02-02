package com.kosign.easy_cart.payload.product;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.kosign.easy_cart.common.api.Pagination;
import com.kosign.easy_cart.payload.user.UserResponse;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.domain.Page;

import java.util.List;

@Data
@JsonInclude
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonPropertyOrder({"products", "pagination"})
public class ProductMainResponse {

    private Pagination pagination;
    private List<ProductResponse> products;

    @Builder
    public ProductMainResponse(Page<?> page, List<ProductResponse> products) {
        this.pagination = new Pagination(page);
        this.products = products;
    }

}
