package com.urbanbank.service.exception;

public class NotFoundException extends BusinessException {

    private static final long SERIAL_VERSION_UID = 1L;

    public NotFoundException() {
        super("Recurso não encontrado");
    }
}
