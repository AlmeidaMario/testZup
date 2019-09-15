package com.zupteste.zuptest.controller;

import com.zupteste.zuptest.domain.State;
import com.zupteste.zuptest.dto.StateDTO;
import com.zupteste.zuptest.mapper.StateMapper;
import com.zupteste.zuptest.service.StateService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(value = "State Controller")
@RestController
@RequestMapping(value = "/state")
public class StateController {

    @Autowired
    StateService service;

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "Find State by id")
    public StateDTO findById(final @ApiParam(value = "id", required = true) @PathVariable Long id){
        return StateMapper.convertToDTO(service.get(id));
    }

    @GetMapping
    @ApiOperation(value = "Find All State with pageable")
    public Page<State> getAllStatePage(Pageable pageable, @RequestParam(value = "name",required = false)  String name){
        Page<State> states = service.getAllPaginated(pageable, name);
        return states;
    }

    @PostMapping()
    @ApiOperation("new State ")
    public StateDTO create(@ApiParam(value = "State", required = true)
                            @RequestBody @Valid final StateDTO dto){
        final State state = StateMapper.convertToEntity(dto);
        return StateMapper.convertToDTO(service.addOrUpdate(state));
    }

    @PutMapping("/{id}")
    @ApiOperation("update State")
    public StateDTO update(@ApiParam(value = "Client", required = true)
                            @RequestBody @Valid final StateDTO dto){
        final State state = StateMapper.convertToEntity(dto);
        return StateMapper.convertToDTO(service.addOrUpdate(state));
    }

    @DeleteMapping("/{id}")
    @ApiOperation("delete State")
    public void delete(@ApiParam(value = "id", required = true) @PathVariable final Long id){
        service.removeById(id);
    }
}