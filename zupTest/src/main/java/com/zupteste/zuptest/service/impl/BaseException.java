package com.zupteste.zuptest.service.impl;

import com.zupteste.zuptest.exception.NotFoundException;

import java.util.Optional;

class BaseException {

     void verityNotFoundException(Optional<?> optional) throws NotFoundException {
        if(!optional.isPresent()){
            throw new NotFoundException("Error Not Found");
        }
    }
}
