package com.kosign.easy_cart.payload.category;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class AllCategoryResponse {

    private Long id;
    private String name;
}
