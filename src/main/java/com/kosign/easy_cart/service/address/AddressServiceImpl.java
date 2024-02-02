package com.kosign.easy_cart.service.address;

import com.kosign.easy_cart.entity.Address;
import com.kosign.easy_cart.entity.User;
import com.kosign.easy_cart.exception.EntityNotFoundException;
import com.kosign.easy_cart.payload.address.DeliveryAddressRequest;
import com.kosign.easy_cart.payload.address.DeliveryAddressResponse;
import com.kosign.easy_cart.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService{

    private final AddressRepository addressRepository;

    @Override
    public void createNewAddressDelivery(DeliveryAddressRequest deliveryAddressRequest) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        addressRepository.save(Address.builder()
                .address(deliveryAddressRequest.getAddress())
                .label(deliveryAddressRequest.getLabel())
                .contact(deliveryAddressRequest.getContact())
                .tel(deliveryAddressRequest.getTelephone())
                .detail(deliveryAddressRequest.getDetail())
                .user(user)
                .build()
        );
    }

    @Override
    public DeliveryAddressResponse getDeliveryAddressById(Long id) {
        var address = addressRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(Address.class, "id", id.toString()));
        return DeliveryAddressResponse.builder()
                .id(address.getId())
                .label(address.getLabel())
                .contact(address.getAddress())
                .telephone(address.getTel())
                .address(address.getAddress())
                .detail(address.getDetail())
                .build();
    }


}
