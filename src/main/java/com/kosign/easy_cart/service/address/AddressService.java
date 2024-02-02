package com.kosign.easy_cart.service.address;

import com.kosign.easy_cart.payload.address.DeliveryAddressRequest;
import com.kosign.easy_cart.payload.address.DeliveryAddressResponse;

public interface AddressService {

    void createNewAddressDelivery(DeliveryAddressRequest deliveryAddressRequest);

    DeliveryAddressResponse getDeliveryAddressById(Long id);

}
