package com.zupteste.zuptest.config.handler;

import org.springframework.validation.FieldError;

public class ErrorForm {
    public String field;
    public String message;

    public ErrorForm(final FieldError fieldError){
        this.field = fieldError.getField();
        this.message = fieldError.getDefaultMessage();
    }
}
