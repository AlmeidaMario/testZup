package com.zupteste.zupTest.service.impl;

import com.zupteste.zupTest.domain.City;
import com.zupteste.zupTest.repository.CityRepository;
import com.zupteste.zupTest.service.CityService;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CityServiceImpl extends BaseException implements CityService {

    @Autowired
    CityRepository repository;

    @Override
    public Page<City> getAllPaginated(Pageable pageable, String value) {
        if (Objects.isNull(value)) {
            return repository.findAll(pageable);
        } else {
            return repository.findByNameContains(pageable, value);
        }
    }

    @Override
    public City get(Long id) {
        Optional<City> city = repository.findById(id);
        super.verityNotFoundException(city);
        return city.get();
    }

    @Override
    public City addOrUpdate(City entity) {
        return this.repository.save(entity);
    }

    @Override
    public void remove(City entity) {
        repository.delete(entity);
    }

    @Override
    public void removeById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Page<City> getAllPaginated(Pageable pageable){
        return null;
    }

    @Override
    public List<City> getAll() {
        return null;
    }
}
