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
    public City saveOrUpdate(City entity) throws Exception {
        try {
            return repository.save(entity);
        } catch (ConstraintViolationException e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<City> getAllPaginated(Pageable pageable, String value) throws Exception {
        try {
            if (Objects.isNull(value)) {
                return repository.findAll(pageable);
            } else {
                return repository.findByNameContains(pageable, value);
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public City get(Long id) {
        Optional<City> city = repository.findById(id);
        super.verityNotFoundException(city);
        return city.get();
    }

    @Override
    public City add(City entity) throws Exception {
        try {
            City addCity = saveOrUpdate(entity);
            return addCity;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public City update(City entity) throws Exception {
        try {
            City updateCity = saveOrUpdate(entity);
            return updateCity;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public void remove(City entity) throws Exception {
        try {
            repository.delete(entity);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public void removeById(Long id) throws Exception {
        try {
            repository.deleteById(id);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<City> getAllPaginated(Pageable pageable) throws Exception {
        return null;
    }

    @Override
    public List<City> getAll() {
        return null;
    }
}
