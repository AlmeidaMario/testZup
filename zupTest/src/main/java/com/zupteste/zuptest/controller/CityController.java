package com.zupteste.zuptest.controller;

import com.zupteste.zuptest.domain.City;
import com.zupteste.zuptest.dto.CityDTO;
import com.zupteste.zuptest.mapper.CityMapper;
import com.zupteste.zuptest.service.CityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(value = "City Controller")
@RestController
@RequestMapping(value = "/city")
public class CityController {

    @Autowired
    CityService service;

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "Find City by id")
    public CityDTO findById(final @ApiParam(value = "id", required = true) @PathVariable Long id){
        return CityMapper.convertToDTO(service.get(id));
    }

    @GetMapping
    @ApiOperation(value = "Find All City with pageable")
    public Page<City> getAllCityPage(final Pageable pageable, final @RequestParam(value = "name",required = false)  String name){
        return service.getAllPaginated(pageable, name);
    }

    @PostMapping()
    @ApiOperation("new City ")
    public CityDTO create(@ApiParam(value = "City", required = true)
                           @RequestBody @Valid final CityDTO dto){
        final City city = CityMapper.convertToEntity(dto);
        return CityMapper.convertToDTO(service.addOrUpdate(city));
    }

    @PutMapping("/{id}")
    @ApiOperation("update City")
    public CityDTO update(@ApiParam(value = "Client", required = true)
                           @RequestBody @Valid final CityDTO dto){
        final City city = CityMapper.convertToEntity(dto);
        return CityMapper.convertToDTO(service.addOrUpdate(city));
    }

    @DeleteMapping("/{id}")
    @ApiOperation("delete City")
    public void delete(@ApiParam(value = "id", required = true) @PathVariable final Long id){
        service.removeById(id);
    }

}
