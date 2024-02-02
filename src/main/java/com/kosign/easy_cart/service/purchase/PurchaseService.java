package com.kosign.easy_cart.service.purchase;

import com.kosign.easy_cart.payload.purchase.PurchaseRequest;

public interface PurchaseService {

    void purchaseProduct(PurchaseRequest purchaseRequest);
}
