package com.kosign.easy_cart.service.otp;

import com.kosign.easy_cart.payload.pincode.PinCodeRequest;

public interface OTPService {
    PinCodeRequest generatePinCode(String email);

    String confirmPinCode(String email, String pinCode);

}
