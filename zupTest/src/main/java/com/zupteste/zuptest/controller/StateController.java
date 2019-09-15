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

@Api(value = "State Controller")//NOPMD
@RestController
@RequestMapping(value = "/state")//NOPMD
public class StateController {//NOPMD

    @Autowired
    private StateService service;//NOPMD

    @GetMapping(value = "/{id}")//NOPMD
    @ApiOperation(value = "Find State by id")//NOPMD
    public StateDTO findById(final @ApiParam(value = "id", required = true) @PathVariable Long id){//NOPMD
        return StateMapper.convertToDTO(service.get(id));
    }

    @GetMapping
    @ApiOperation(value = "Find All State with pageable")//NOPMD
    public Page<State> getAllStatePage(final Pageable pageable, final @RequestParam(value = "name",required = false)  String name){//NOPMD
        final Page<State> states = service.getAllPaginated(pageable, name);
        return states;//NOPMD
    }

    @PostMapping()
    @ApiOperation("new State ")
    public StateDTO create(@ApiParam(value = "State", required = true)//NOPMD
                            @RequestBody @Valid final StateDTO dto){
        final State state = StateMapper.convertToEntity(dto);
        return StateMapper.convertToDTO(service.addOrUpdate(state));
    }

    @PutMapping("/{id}")
    @ApiOperation("update State")
    public StateDTO update(@ApiParam(value = "Client", required = true)//NOPMD
                            @RequestBody @Valid final StateDTO dto){
        final State state = StateMapper.convertToEntity(dto);
        return StateMapper.convertToDTO(service.addOrUpdate(state));
    }

    @DeleteMapping("/{id}")
    @ApiOperation("delete State")
    public void delete(@ApiParam(value = "id", required = true) @PathVariable final Long id){//NOPMD
        service.removeById(id);
    }
}