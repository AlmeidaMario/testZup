package com.zupteste.zupTest.service.impl;

import com.zupteste.zupTest.domain.Address;
import com.zupteste.zupTest.domain.State;
import com.zupteste.zupTest.repository.AddressRepository;
import com.zupteste.zupTest.service.AddressService;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class AddressServiceImpl extends BaseException implements AddressService {

    @Autowired
    AddressRepository repository;

    @Override
    public Page<Address> getAllPaginated(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Page<Address> getAllPaginatedAdress(Pageable pageable, String cityName, String district) {
        /*Nesse caso será dado a opção para pesquisa tanto por Cidade e Bairro, quanto por cada um....*/
        if (Objects.nonNull(cityName) && Objects.nonNull(district)) {
            return repository.findAllByCity_NameAndDistrict(pageable, cityName, district);
        } else if (Objects.nonNull(cityName)) {
            return repository.findAllByCity_Name(pageable, cityName);
        } else if (Objects.nonNull(district)) {
            return repository.findAllByDistrictContains(pageable, district);
        } else {
            return repository.findAll(pageable);
        }
    }

    @Override
    public Address get(Long id) {
        Optional<Address> address = repository.findById(id);
        super.verityNotFoundException(address);
        return address.get();
    }

    @Override
    public Address addOrUpdate(Address entity){
        return this.repository.save(entity);
    }

    @Override
    public void remove(Address entity) {
        repository.delete(entity);
    }

    @Override
    public void removeById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<Address> getAll() {
        return null;
    }

    @Override
    public Page<Address> getAllPaginated(Pageable pageable, String value){
        return null;
    }

}
