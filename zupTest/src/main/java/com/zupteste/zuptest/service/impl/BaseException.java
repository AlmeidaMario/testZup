package com.zupteste.zuptest.service.impl;

import com.zupteste.zuptest.exception.NotFoundException;

import java.util.Optional;

class BaseException {//NOPMD

     public void verityNotFoundException(final Optional<?> optional) throws NotFoundException {//NOPMD
        if(!optional.isPresent()){
            throw new NotFoundException("Error Not Found");
        }
    }
}
