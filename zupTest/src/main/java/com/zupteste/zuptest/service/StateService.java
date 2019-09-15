package com.zupteste.zuptest.service;
import com.zupteste.zuptest.domain.State;

public interface StateService extends GenericService<State,Long> {//NOPMD
    State getByName(String name);//NOPMD
}
