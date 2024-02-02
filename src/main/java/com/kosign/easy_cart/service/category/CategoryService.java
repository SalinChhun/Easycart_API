package com.kosign.easy_cart.service.category;

import com.kosign.easy_cart.entity.Category;
import com.kosign.easy_cart.payload.category.AllCategoryResponse;
import com.kosign.easy_cart.payload.category.CategoryRequest;

import java.util.List;

public interface CategoryService {

    void createNewCategory(CategoryRequest category);

    List<AllCategoryResponse> getAllCategory();

    Category getCategoryByName(String categoryName);
}
