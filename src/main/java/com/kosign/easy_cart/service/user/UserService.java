package com.kosign.easy_cart.service.user;

import com.kosign.easy_cart.payload.auth.ResetPasswordRequest;
import com.kosign.easy_cart.payload.user.UserResponse;
import com.kosign.easy_cart.payload.user.ChangePasswordRequest;
import org.springframework.data.domain.Pageable;

import java.security.Principal;

public interface UserService {

    Object getAllUser(Pageable pageable);

    UserResponse getUserById(Integer id);

    void deleteUserById(Integer id);

    public void changePassword(ChangePasswordRequest request, Principal connectedUser);

    void resetPassword(ResetPasswordRequest resetPasswordRequest, Principal connectedUser);

    UserResponse getUserDetailsByCurrentUser();

}
