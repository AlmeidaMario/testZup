package com.zupteste.zuptest.controller;

import com.zupteste.zuptest.domain.Address;
import com.zupteste.zuptest.dto.AddressDTO;
import com.zupteste.zuptest.mapper.AddressMapper;
import com.zupteste.zuptest.service.AddressService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(value = "Address Controller")
@RestController
@RequestMapping(value = "/address")
public class AddressController {

    @Autowired
    AddressService service;

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "Find Address by id")
    public AddressDTO findById(final @ApiParam(value = "id", required = true) @PathVariable Long id){
        return AddressMapper.convertToDTO(service.get(id));
    }

    @GetMapping
    @ApiOperation(value = "Find All Address with pageable")
    public Page<Address> getAllAddressPage(final Pageable pageable,
                                           final @RequestParam(value = "cityName",required = false)  String cityName,
                                           final @RequestParam(value = "district",required = false)  String district){
        return service.getAllPaginatedAdress(pageable, cityName, district);
    }

    @PostMapping()
    @ApiOperation("new Address ")
    public AddressDTO create(@ApiParam(value = "State", required = true)
                                 @RequestBody @Valid final AddressDTO dto){
        final Address address = AddressMapper.convertToEntity(dto);
        return AddressMapper.convertToDTO(service.addOrUpdate(address));
    }

    @PutMapping("/{id}")
    @ApiOperation("update Address")
    public AddressDTO update(@ApiParam(value = "Client", required = true)
                          @RequestBody @Valid final AddressDTO dto){
        final Address address = AddressMapper.convertToEntity(dto);
        return AddressMapper.convertToDTO(service.addOrUpdate(address));
    }

    @DeleteMapping("/{id}")
    @ApiOperation("delete Address")
    public void delete(@ApiParam(value = "id", required = true) @PathVariable final Long id){
        service.removeById(id);
    }
}
