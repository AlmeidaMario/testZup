package com.zupteste.zupTest.controller;

import com.zupteste.zupTest.domain.State;
import com.zupteste.zupTest.dto.StateDTO;
import com.zupteste.zupTest.mapper.StateMapper;
import com.zupteste.zupTest.service.StateService;
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
    public StateDTO findById(@ApiParam(value = "id", required = true) @PathVariable Long id) throws Exception {
        return StateMapper.convertToDTO(service.get(id));
    }

    @GetMapping
    @ApiOperation(value = "Find All State with pageable")
    public Page<State> getAllStatePage(Pageable pageable, @RequestParam(value = "name",required = false)  String name) throws Exception {
        Page<State> states = service.getAllPaginated(pageable, name);
        return states;
    }

    @PostMapping()
    @ApiOperation("new State ")
    public StateDTO create(@ApiParam(value = "State", required = true)
                            @RequestBody @Valid final StateDTO dto) throws Exception {
        final State state = StateMapper.convertToEntity(dto);
        return StateMapper.convertToDTO(service.addOrUpdate(state));
    }

    @PutMapping("/{id}")
    @ApiOperation("update State")
    public StateDTO update(@ApiParam(value = "Client", required = true)
                            @RequestBody @Valid final StateDTO dto) throws Exception {
        final State state = StateMapper.convertToEntity(dto);
        return StateMapper.convertToDTO(service.addOrUpdate(state));
    }

    @DeleteMapping("/{id}")
    @ApiOperation("delete State")
    public void delete(@ApiParam(value = "id", required = true) @PathVariable final Long id) throws Exception {
        service.removeById(id);
    }
}