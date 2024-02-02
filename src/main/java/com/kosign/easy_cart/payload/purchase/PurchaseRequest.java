package com.kosign.easy_cart.payload.purchase;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PurchaseRequest {

    private Long deliveryAddressId;
    private String paymentMethod;
    private Long productId;
    private String remark;
    private String paidBy;
}
