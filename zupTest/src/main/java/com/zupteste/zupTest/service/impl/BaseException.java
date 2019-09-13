package com.zupteste.zupTest.service.impl;

import com.zupteste.zupTest.exception.NotFoundException;

import java.util.Optional;

abstract class BaseException {

     void verityNotFoundException(Optional<?> optional) throws NotFoundException {
        if(!optional.isPresent()){
            throw new NotFoundException("Error Not Found");
        }
    }
}
