package com.zupteste.zupTest.mapper;


import com.zupteste.zupTest.domain.Client;
import com.zupteste.zupTest.dto.ClientDTO;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClientMapperTest {

    @Test
    public void convertDtoToEntity() {
        ClientDTO dto = new ClientDTO((long) 1,"01096709228","Mario Ferreira de Almeida Neto");
        Client entity = ClientMapper.convertToEntity(dto);
        checkProperties(dto, entity);
    }

    //
    @Test
    public void convertEntityToDto() {
        Client entity = new Client((long) 1, "01096709228", "Mario Ferreira de Almeida Neto");
        ClientDTO dto = ClientMapper.convertToDTO(entity);
        checkProperties(dto, entity);
    }


    @Test
    public void convertListToEntityList() {
        ClientDTO dto1 = new ClientDTO((long) 1,"01096709228","Mario Ferreira de Almeida Neto");
        ClientDTO dto2 = new ClientDTO((long) 2,"01619415240","André Preto");
        List<ClientDTO> listDTOS = Arrays.asList(dto1, dto2);

        final List<Client> entities = ClientMapper.convertToListEntity(listDTOS);
        assertEquals(listDTOS.size(), entities.size());
        for (int i = 0; i < entities.size(); i++) {
            checkProperties(listDTOS.get(i), entities.get(i));
        }
    }

    @Test
    public void convertListToDtoList() {
        Client entity1 = new Client((long) 1,"01096709228","Mario Ferreira de Almeida Neto");
        Client entity2 = new Client((long) 1,"01096709228","Mario Ferreira de Almeida Neto");
        List<Client> entities = Arrays.asList(entity1, entity2);
        final List<ClientDTO> listDTOS = ClientMapper.convertToListDTO(entities);

        assertEquals(entities.size(), listDTOS.size());

        for (int i = 0; i < listDTOS.size(); i++) {
            checkProperties(listDTOS.get(i), entities.get(i));
        }
    }

    private void checkProperties(ClientDTO dto, Client entity) {
        assertEquals(dto.getId(), entity.getId());
        assertEquals(dto.getCpf(), entity.getCpf());
        assertEquals(dto.getName(), entity.getName());

    }


}
