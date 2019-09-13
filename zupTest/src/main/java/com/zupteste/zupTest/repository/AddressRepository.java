package com.zupteste.zupTest.repository;

import com.zupteste.zupTest.domain.Address;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

    Page<Address> findAllByCity_NameAndDistrict(Pageable pageable, String cityName, String district);
    Page<Address> findAllByCity_Name(Pageable pageable, String cityName);
    Page<Address> findAllByDistrict(Pageable pageable, String district);


}
