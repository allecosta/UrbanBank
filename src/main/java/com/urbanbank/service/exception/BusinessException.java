package com.urbanbank.service.exception;

public class BusinessException extends RuntimeException {

    private static final long SERIAL_VERSION_UID = 1L;

    public BusinessException(String message) {
        super(message);
    }
}
