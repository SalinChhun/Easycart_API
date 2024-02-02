package com.kosign.easy_cart.payload.address;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeliveryAddressResponse {

    private Long id;

    private String label;

    private String contact;

    private String telephone;

    private String address;

    private String detail;

    @Builder
    public DeliveryAddressResponse(
            Long id,
            String label,
          String contact,
          String telephone,
          String address,
          String detail
    ) {
        this.id = id;
        this.label = label;
        this.contact = contact;
        this.telephone = telephone;
        this.address = address;
        this.detail = detail;
    }
}
