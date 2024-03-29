package com.zupteste.zuptest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {//NOPMD

    public NotFoundException(final String message){//NOPMD
        super(message);
    }

}
