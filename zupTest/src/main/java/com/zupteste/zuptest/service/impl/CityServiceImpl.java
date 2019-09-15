package com.zupteste.zuptest.service.impl;

import com.zupteste.zuptest.domain.City;
import com.zupteste.zuptest.repository.CityRepository;
import com.zupteste.zuptest.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CityServiceImpl extends BaseException implements CityService {//NOPMD

    @Autowired
    private CityRepository repository;//NOPMD

    @Override
    public Page<City> getAllPaginated(final Pageable pageable, final String value) {
        if (Objects.isNull(value)) {
            return repository.findAll(pageable);//NOPMD
        } else {
            return repository.findByNameContains(pageable, value);
        }
    }

    @Override
    public City get(Long id) {//NOPMD
        final Optional<City> city = repository.findById(id);
        super.verityNotFoundException(city);
        return city.get();//NOPMD
    }

    @Override
    public City getByName(final String name) {
        return repository.findByName(name);
    }

    @Override
    public City addOrUpdate(final City entity) {
        return this.repository.save(entity);
    }

    @Override
    public void remove(final City entity) {
        repository.delete(entity);
    }

    @Override
    public void removeById(Long id) {//NOPMD
        repository.deleteById(id);
    }

    @Override
    public Page<City> getAllPaginated(final Pageable pageable){
        return null;
    }

    @Override
    public List<City> getAll() {
        return null;
    }
}
