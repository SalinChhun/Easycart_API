package com.kosign.easy_cart.repository;

import com.kosign.easy_cart.entity.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseRepository extends JpaRepository<Purchase, Long> {
}
