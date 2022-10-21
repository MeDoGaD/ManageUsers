package com.cis.manageAccounts.errors;

import org.springframework.http.HttpStatus;

public class ConflictException extends APIBaseException {

    public ConflictException(String message) {
        super(message);
    }

    @Override
    public HttpStatus getStatus() {
        return HttpStatus.CONFLICT;
    }
}
