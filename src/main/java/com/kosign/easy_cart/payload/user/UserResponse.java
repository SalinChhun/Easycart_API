package com.kosign.easy_cart.payload.user;


import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UserResponse {

    private Integer id;

    private String firstName;

    private String lastName;

    private String email;

    private String phoneNumber;

    private String role;

    private String profilePhoto;

    private Boolean status;

    private String googleLink;

    private String mapLink;

    private LocalDateTime createdDate;

    @Builder
    public UserResponse(Integer id, String firstName, String lastName, String email, String phoneNumber, String role, String profilePhoto, Boolean status, String googleLink, String mapLink, LocalDateTime createdDate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.role = role;
        this.profilePhoto = profilePhoto;
        this.status = status;
        this.googleLink = googleLink;
        this.mapLink = mapLink;
        this.createdDate = createdDate;
    }
}
