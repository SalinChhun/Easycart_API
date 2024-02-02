package com.kosign.easy_cart.service.purchase;

import com.kosign.easy_cart.entity.Address;
import com.kosign.easy_cart.entity.Purchase;
import com.kosign.easy_cart.payload.purchase.PurchaseRequest;
import com.kosign.easy_cart.repository.PurchaseRepository;
import com.kosign.easy_cart.service.address.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class PurchaseServiceImpl implements PurchaseService{

    private final PurchaseRepository purchaseRepository;
    private final AddressService addressService;
    @Override
    public void purchaseProduct(PurchaseRequest purchaseRequest) {
        var address = addressService.getDeliveryAddressById(purchaseRequest.getDeliveryAddressId());
        purchaseRepository.save(
                Purchase.builder()
                        .address(Address.builder()
                                .id(address.getId())
                                .label(address.getLabel())
                                .contact(address.getContact())
                                .tel(address.getAddress())
                                .detail(address.getDetail())
                                .build())
                        .paymentMethod(purchaseRequest.getPaymentMethod())
//                        .product()
                        .createdDate(LocalDateTime.now())
                        .build()
        );
    }
}
