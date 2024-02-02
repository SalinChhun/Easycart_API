package com.kosign.easy_cart.service.product;

import com.kosign.easy_cart.entity.Product;
import com.kosign.easy_cart.payload.product.ProductRequest;
import com.kosign.easy_cart.payload.product.ProductResponse;
import org.springframework.data.domain.Pageable;

public interface ProductService {

    public void postNewProduct(ProductRequest productRequest, String categoryName);

    Object getAllProduct(Pageable pageable);

    Object getAllProductByCurrentUser(Pageable pageable);

    ProductResponse getProductById(Long productId);

    void hiddenProduct(Long productId);


}
