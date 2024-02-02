package com.kosign.easy_cart.payload.photo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PhotoResponse {

    private Long id;
    private String photo;

    @Builder
    public PhotoResponse(Long id, String photo) {
        this.id = id;
        this.photo = photo;
    }
}
