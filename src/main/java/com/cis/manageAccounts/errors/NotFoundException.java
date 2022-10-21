package com.cis.manageAccounts.errors;

import org.springframework.http.HttpStatus;

public class NotFoundException extends APIBaseException{

    public NotFoundException(String message) {
        super(message);
    }

    @Override
    public HttpStatus getStatus() {
        return HttpStatus.NOT_FOUND;
    }
}
