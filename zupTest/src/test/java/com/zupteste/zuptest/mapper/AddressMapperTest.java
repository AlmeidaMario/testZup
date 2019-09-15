package com.zupteste.zuptest.mapper;

import com.zupteste.zuptest.domain.Address;
import com.zupteste.zuptest.dto.AddressDTO;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddressMapperTest {

    @Test
    void convertDtoToEntity() {
        AddressDTO dto = new AddressDTO((long) 1, 8,"Tasso da Silveira","Cidade Deus");
        Address entity = AddressMapper.convertToEntity(dto);
        checkProperties(dto, entity);
    }

    @Test
    void convertEntityToDto() {
        Address entity = new Address((long) 1, 8,"Tasso da Silveira","Cidade Deus");
        AddressDTO dto = AddressMapper.convertToDTO(entity);
        checkProperties(dto, entity);
    }


    @Test
    void convertListToEntityList() {
        AddressDTO dto1 = new AddressDTO((long) 1, 8,"Tasso da Silveira","Cidade Deus");
        AddressDTO dto2 = new AddressDTO((long) 2, 527,"Anhandui","Flores");
        List<AddressDTO> listDTOS = Arrays.asList(dto1, dto2);

        final List<Address> entities = AddressMapper.convertToListEntity(listDTOS);
        assertEquals(listDTOS.size(), entities.size());
        for (int i = 0; i < entities.size(); i++) {
            checkProperties(listDTOS.get(i), entities.get(i));
        }
    }

    @Test
    void convertListToDtoList() {
        Address entity1 = new Address((long) 1, 8,"Tasso da Silveira","Cidade Deus");
        Address entity2 = new Address((long) 2, 527,"Anhandui","Flores");
        List<Address> entities = Arrays.asList(entity1, entity2);
        final List<AddressDTO> listDTOS = AddressMapper.convertToListDTO(entities);

        assertEquals(entities.size(), listDTOS.size());

        for (int i = 0; i < listDTOS.size(); i++) {
            checkProperties(listDTOS.get(i), entities.get(i));
        }
    }

    private void checkProperties(AddressDTO dto, Address entity) {
        assertEquals(dto.getId(), entity.getId());
        assertEquals(dto.getNumber(), entity.getNumber());
        assertEquals(dto.getStreet(), entity.getStreet());
        assertEquals(dto.getDistrict(), entity.getDistrict());
    }
}
