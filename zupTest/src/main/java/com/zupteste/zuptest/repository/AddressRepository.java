package com.zupteste.zuptest.repository;

import com.zupteste.zuptest.domain.Address;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {//NOPMD

    Page<Address> findAllByCity_NameAndDistrict(Pageable pageable, String cityName, String district);//NOPMD
    Page<Address> findAllByCity_Name(Pageable pageable, String cityName);//NOPMD
    Page<Address> findAllByDistrictContains(Pageable pageable, String district);//NOPMD

    Address findByDistrict(String name);//NOPMD


}
