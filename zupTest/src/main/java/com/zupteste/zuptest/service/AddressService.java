package com.zupteste.zuptest.service;

import com.zupteste.zuptest.domain.Address;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AddressService extends GenericService<Address,Long> {//NOPMD

    Page<Address> getAllPaginatedAdress(Pageable pageable, String cityName, String district);//NOPMD
    Address getByDistrict(String district);//NOPMD

}
