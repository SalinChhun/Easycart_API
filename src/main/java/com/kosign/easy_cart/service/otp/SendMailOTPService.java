package com.kosign.easy_cart.service.otp;

import com.kosign.easy_cart.payload.pincode.PinCodeRequest;

public interface SendMailOTPService {

    public void sendMailOTP(PinCodeRequest pinCodeRequest);
}
