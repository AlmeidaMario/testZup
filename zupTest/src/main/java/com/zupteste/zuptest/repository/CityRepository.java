package com.zupteste.zuptest.repository;

import com.zupteste.zuptest.domain.City;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
    Page<City> findByNameContains(Pageable pageable, String value);

    City findByName(String name);
}
