package com.zupteste.zuptest.service;
import com.zupteste.zuptest.domain.State;

public interface StateService extends GenericService<State,Long> {
    State getByName(String name);
}
