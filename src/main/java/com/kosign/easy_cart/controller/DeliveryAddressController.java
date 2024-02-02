package com.kosign.easy_cart.controller;

import com.kosign.easy_cart.payload.address.DeliveryAddressRequest;
import com.kosign.easy_cart.service.address.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/delivery-address")
public class DeliveryAddressController extends ResController{

    private final AddressService deliveryAddressService;

    @PostMapping("/create-delivery-address")
    ResponseEntity<?> createNewDeliveryAddress(@RequestBody DeliveryAddressRequest deliveryAddressRequest) {
        deliveryAddressService.createNewAddressDelivery(deliveryAddressRequest);
        return ok();
    }
}
