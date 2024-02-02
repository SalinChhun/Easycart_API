package com.kosign.easy_cart.controller;

import com.kosign.easy_cart.payload.purchase.PurchaseRequest;
import com.kosign.easy_cart.service.purchase.PurchaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/purchase")
public class PurchaseController extends ResController{

    private final PurchaseService purchaseService;

    @PostMapping("/purchase-product")
    ResponseEntity<?> purchaseProduct(@RequestBody PurchaseRequest purchaseRequest) {
        purchaseService.purchaseProduct(purchaseRequest);
        return ok();
    }
}
