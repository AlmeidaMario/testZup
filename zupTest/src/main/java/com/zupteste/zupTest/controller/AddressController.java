package com.zupteste.zupTest.controller;

import com.zupteste.zupTest.domain.Address;
import com.zupteste.zupTest.dto.AddressDTO;
import com.zupteste.zupTest.mapper.AddressMapper;
import com.zupteste.zupTest.service.AddressService;
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
    public AddressDTO findById(@ApiParam(value = "id", required = true) @PathVariable Long id) throws Exception {
        return AddressMapper.convertToDTO(service.get(id));
    }

    @GetMapping
    @ApiOperation(value = "Find All Address with pageable")
    public Page<Address> getAllStatePage(Pageable pageable,
                                         @RequestParam(value = "cityName",required = false)  String cityName,
                                         @RequestParam(value = "district",required = false)  String district) throws Exception {
        Page<Address> addresses = service.getAllPaginatedAdress(pageable, cityName, district);
        return addresses;
    }

    @PostMapping()
    @ApiOperation("new Address ")
    public AddressDTO create(@ApiParam(value = "State", required = true)
                          @RequestBody @Valid final AddressDTO dto) throws Exception {
        final Address address = AddressMapper.convertToEntity(dto);
        return AddressMapper.convertToDTO(service.add(address));
    }

    @PutMapping("/{id}")
    @ApiOperation("update Address")
    public AddressDTO update(@ApiParam(value = "Client", required = true)
                          @RequestBody @Valid final AddressDTO dto) throws Exception {
        final Address address = AddressMapper.convertToEntity(dto);
        return AddressMapper.convertToDTO(service.update(address));
    }

    @DeleteMapping("/{id}")
    @ApiOperation("delete Address")
    public void delete(@ApiParam(value = "id", required = true) @PathVariable final Long id) throws Exception {
        service.removeById(id);
    }
}
