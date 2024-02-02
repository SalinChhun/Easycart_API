package com.kosign.easy_cart.repository;

import com.kosign.easy_cart.entity.Product;
import com.kosign.easy_cart.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("select p from Product p order by p.id DESC")
    Page<Product> findByOrderByIdDesc(Pageable pageable);

    @Query("select p from Product p where p.user.id = ?1 order by p.id DESC")
    Page<Product> findByUser_Id(Integer id, Pageable pageable);


}
