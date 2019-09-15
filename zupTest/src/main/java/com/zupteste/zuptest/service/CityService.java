package com.zupteste.zuptest.service;

import com.zupteste.zuptest.domain.City;

public interface CityService extends GenericService<City,Long> {

    City getByName(String name);

}
