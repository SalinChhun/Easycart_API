package com.kosign.easy_cart.repository;

import com.kosign.easy_cart.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
