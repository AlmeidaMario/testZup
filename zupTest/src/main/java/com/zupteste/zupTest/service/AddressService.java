package com.zupteste.zupTest.service;

import com.zupteste.zupTest.domain.Address;
import com.zupteste.zupTest.repository.AddressRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AddressService extends GenericService<Address,Long> {

    Page<Address> getAllPaginatedAdress(Pageable pageable, String cityName, String district);

}
