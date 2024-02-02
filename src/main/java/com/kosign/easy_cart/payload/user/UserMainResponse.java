package com.kosign.easy_cart.payload.user;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.kosign.easy_cart.common.api.Pagination;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.domain.Page;

import java.util.List;

@Data
@JsonInclude
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonPropertyOrder({"users", "pagination"})
public class UserMainResponse {

    private Pagination pagination;
    private List<UserResponse> users;

    @Builder
    public UserMainResponse(Page<?> page, List<UserResponse> users) {
        this.pagination = new Pagination(page);
        this.users = users;
    }
}
