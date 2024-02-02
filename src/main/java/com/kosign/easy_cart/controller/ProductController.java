package com.kosign.easy_cart.controller;

import com.kosign.easy_cart.entity.Product;
import com.kosign.easy_cart.payload.MultiSortBuilder;
import com.kosign.easy_cart.payload.product.ProductRequest;
import com.kosign.easy_cart.payload.product.ProductResponse;
import com.kosign.easy_cart.service.category.CategoryService;
import com.kosign.easy_cart.service.product.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/product")
@RequiredArgsConstructor
public class ProductController extends ResController{

    private final ProductService productService;
    private final CategoryService categoryService;

    @PostMapping("/post-product")
    ResponseEntity<?> postNewProduct(
            @RequestParam String categoryName,
            @Valid @RequestBody ProductRequest productRequest
    ) {
        categoryService.getCategoryByName(categoryName);
        productService.postNewProduct(productRequest, categoryName);
        return ok();
    }

    @GetMapping("/get-all-product")
    ResponseEntity<?> getAllProduct(
            @RequestParam(name = "page_number", defaultValue = "0") Integer pageNumber,
            @RequestParam(name = "page_size", defaultValue = "10") Integer pageSize,
            @RequestParam(value = "sort_column", required = false, defaultValue = "id:desc") String sortColumns
    ) {
        List<Sort.Order> sortBuilder = new MultiSortBuilder().with(sortColumns).build();
        Pageable pageRequest = PageRequest.of(pageNumber, pageSize, Sort.by(sortBuilder));
        return ok(productService.getAllProduct(pageRequest));
    }

    @GetMapping("/{productId}")
    ResponseEntity<?> getProductById(@PathVariable Long productId) {
        ProductResponse product = productService.getProductById(productId);
        return ok(product);
    }

    @PutMapping("hidden-product/{productId}")
    ResponseEntity<?> hiddenProduct(@PathVariable Long productId) {
        productService.hiddenProduct(productId);
        return ok();
    }

    @GetMapping("/get-all-product-current-user")
    ResponseEntity<?> getAllProductByCurrentUser(
            @RequestParam(name = "page_number", defaultValue = "0") Integer pageNumber,
            @RequestParam(name = "page_size", defaultValue = "10") Integer pageSize,
            @RequestParam(value = "sort_column", required = false, defaultValue = "id:desc") String sortColumns
    ) {
        List<Sort.Order> sortBuilder = new MultiSortBuilder().with(sortColumns).build();
        Pageable pageRequest = PageRequest.of(pageNumber, pageSize, Sort.by(sortBuilder));
        return ok(productService.getAllProductByCurrentUser(pageRequest));
    }
}
