package com.kosign.easy_cart.payload.auth;

import lombok.Data;

@Data
public class ResetPasswordRequest {

    private String newPassword;
    private String confirmNewPassword;
}
