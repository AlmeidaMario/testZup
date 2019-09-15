package com.zupteste.zuptest.service;

import com.zupteste.zuptest.domain.City;

public interface CityService extends GenericService<City,Long> {//NOPMD

    City getByName(String name);//NOPMD

}
