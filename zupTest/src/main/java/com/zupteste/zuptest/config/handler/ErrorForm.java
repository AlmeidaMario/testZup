package com.zupteste.zuptest.config.handler;

import org.springframework.validation.FieldError;

public class ErrorForm{//NOPMD
    public String field;//NOPMD
    public String message;//NOPMD

    public ErrorForm(final FieldError fieldError){//NOPMD
        this.field = fieldError.getField();
        this.message = fieldError.getDefaultMessage();
    }
}
