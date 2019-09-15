package com.zupteste.zuptest.service.impl;

import com.zupteste.zuptest.domain.Address;
import com.zupteste.zuptest.repository.AddressRepository;
import com.zupteste.zuptest.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class AddressServiceImpl extends BaseException implements AddressService {//NOPMD

    @Autowired
    private AddressRepository repository;//NOPMD

    @Override
    public Page<Address> getAllPaginated(final Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Page<Address> getAllPaginatedAdress(final Pageable pageable, final String cityName, final String district) {
        /*Nesse caso será dado a opção para pesquisa tanto por Cidade e Bairro, quanto por cada um....*///NOPMD
        if (Objects.nonNull(cityName) && Objects.nonNull(district)) {
            return repository.findAllByCity_NameAndDistrict(pageable, cityName, district);//NOPMD
        } else if (Objects.nonNull(cityName)) {
            return repository.findAllByCity_Name(pageable, cityName);//NOPMD
        } else if (Objects.nonNull(district)) {
            return repository.findAllByDistrictContains(pageable, district);//NOPMD
        } else {
            return repository.findAll(pageable);
        }
    }

    @Override
    public Address getByDistrict(final String district) {
        return repository.findByDistrict(district);
    }

    @Override
    public Address get(Long id) {//NOPMD
        final Optional<Address> address = repository.findById(id);
        super.verityNotFoundException(address);
        return address.get();//NOPMD
    }

    @Override
    public Address addOrUpdate(final Address entity){
        return this.repository.save(entity);
    }

    @Override
    public void remove(final Address entity) {
        repository.delete(entity);
    }

    @Override
    public void removeById(Long id) {//NOPMD
        repository.deleteById(id);
    }

    @Override
    public List<Address> getAll() {
        return null;
    }

    @Override
    public Page<Address> getAllPaginated(final Pageable pageable, final String value){
        return null;
    }

}
