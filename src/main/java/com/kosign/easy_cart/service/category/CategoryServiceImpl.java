package com.kosign.easy_cart.service.category;

import com.kosign.easy_cart.common.api.StatusCode;
import com.kosign.easy_cart.entity.Category;
import com.kosign.easy_cart.exception.BusinessException;
import com.kosign.easy_cart.payload.category.AllCategoryResponse;
import com.kosign.easy_cart.payload.category.CategoryRequest;
import com.kosign.easy_cart.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService{

    private final CategoryRepository categoryRepository;

    @Override
    public void createNewCategory(CategoryRequest category) {
        categoryRepository.save(
                Category.builder()
                        .name(category.getName())
                        .build()
        );
    }

    @Override
    public List<AllCategoryResponse> getAllCategory() {

        List<Category> allCategory = categoryRepository.findAll();
        return allCategory.stream()
                .map(category -> AllCategoryResponse
                        .builder()
                        .id(category.getId())
                        .name(category.getName())
                        .build()
                ).toList();
    }

    @Override
    public Category getCategoryByName(String categoryName) {
        Category category = categoryRepository.findByName(categoryName);
        if (category == null) {
            throw new BusinessException(StatusCode.CATEGORY_NOT_FOUND);
        }
        return category;
    }


}
