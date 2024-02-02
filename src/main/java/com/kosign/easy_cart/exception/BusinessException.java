package com.kosign.easy_cart.exception;


import com.kosign.easy_cart.common.api.StatusCode;

/**
 * Handle exception for Business Exception
 */
public class BusinessException extends RuntimeException {
    private Object body;
    private final StatusCode errorCode;

    public BusinessException(StatusCode errorCode, Object body) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
        this.body = body;
    }

    public BusinessException(StatusCode errorCode, String message) {

        super(message);
        this.errorCode = errorCode;

    }

    public BusinessException(StatusCode errorCode) {

        super(errorCode.getMessage());
        this.errorCode = errorCode;

    }

    public BusinessException(StatusCode errorCode, Throwable e) {

        this(errorCode);
//        AppLogManager.error(e);

    }

    public StatusCode getErrorCode() {
        return errorCode;
    }

    public Object getBody() {
        return body;
    }
}
