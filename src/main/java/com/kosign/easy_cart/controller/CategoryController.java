package com.kosign.easy_cart.controller;

import com.kosign.easy_cart.entity.Category;
import com.kosign.easy_cart.payload.category.CategoryRequest;
import com.kosign.easy_cart.service.category.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/category")
public class CategoryController extends ResController{

    private final CategoryService categoryService;

    @PostMapping("create-new-category")
    ResponseEntity<?> createNewCategory(@Valid @RequestBody CategoryRequest category) {
        categoryService.createNewCategory(category);
        return ok();
    }

    @GetMapping("get-all-category")
    ResponseEntity<?> getAllCategory() {
        return ok(categoryService.getAllCategory());
    }
}
