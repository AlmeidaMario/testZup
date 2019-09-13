package com.zupteste.zupTest.controller;

import com.zupteste.zupTest.domain.Client;
import com.zupteste.zupTest.dto.ClientDTO;
import com.zupteste.zupTest.mapper.ClientMapper;
import com.zupteste.zupTest.service.impl.ClientServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@Api(value = "Client Controller")
@RestController
@RequestMapping(value = "/client")
public class ClientController {

    @Autowired
    ClientServiceImpl service;

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "Find Client by id")
    public ClientDTO findById(@ApiParam(value = "id", required = true) @PathVariable Long id) throws Exception {
        return ClientMapper.convertToDTO(service.get(id));
    }

    @GetMapping
    @ApiOperation(value = "Find All Client with pageable")
    public Page<Client> getAllClientPage(Pageable pageable, @RequestParam(value = "name",required = false)  String name) throws Exception {
        Page<Client> clients = service.getAllPaginated(pageable, name);
        return clients;
    }

    @PostMapping()
    @ApiOperation("new Client ")
    public ClientDTO create(@ApiParam(value = "Client", required = true)
                            @RequestBody @Valid final ClientDTO dto) {
        final Client client = ClientMapper.convertToEntity(dto);
        return ClientMapper.convertToDTO(service.addOrUpdate(client));
    }

    @PutMapping("/{id}")
    @ApiOperation("update Client")
    public ClientDTO update(@ApiParam(value = "Client", required = true)
                            @RequestBody @Valid final ClientDTO dto){
        final Client client = ClientMapper.convertToEntity(dto);
        return ClientMapper.convertToDTO(service.addOrUpdate(client));
    }

    @DeleteMapping("/{id}")
    @ApiOperation("delete Client")
    public void delete(@ApiParam(value = "id", required = true) @PathVariable final Long id) throws Exception {
        service.removeById(id);
    }
}
