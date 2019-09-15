package com.zupteste.zuptest.mapper;


import com.zupteste.zuptest.domain.City;
import com.zupteste.zuptest.dto.CityDTO;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CityMapperTest {

    @Test
    void convertDtoToEntity() {
        CityDTO dto = new CityDTO((long) 1,"Manaus");
        City entity = CityMapper.convertToEntity(dto);
        checkProperties(dto, entity);
    }

    @Test
    void convertEntityToDto() {
        City entity = new City((long) 1,"Manaus");
        CityDTO dto = CityMapper.convertToDTO(entity);
        checkProperties(dto, entity);
    }


    @Test
    void convertListToEntityList() {
        CityDTO dto1 = new CityDTO((long) 1,"Manaus");
        CityDTO dto2 = new CityDTO((long) 2,"Campinas");
        List<CityDTO> listDTOS = Arrays.asList(dto1, dto2);

        final List<City> entities = CityMapper.convertToListEntity(listDTOS);
        assertEquals(listDTOS.size(), entities.size());
        for (int i = 0; i < entities.size(); i++) {
            checkProperties(listDTOS.get(i), entities.get(i));
        }
    }

    @Test
    void convertListToDtoList() {
        City entity1 = new City((long) 1,"Manaus");
        City entity2 = new City((long) 2,"Campinas");
        List<City> entities = Arrays.asList(entity1, entity2);
        final List<CityDTO> listDTOS = CityMapper.convertToListDTO(entities);

        assertEquals(entities.size(), listDTOS.size());

        for (int i = 0; i < listDTOS.size(); i++) {
            checkProperties(listDTOS.get(i), entities.get(i));
        }
    }

    private void checkProperties(CityDTO dto, City entity) {
        assertEquals(dto.getId(), entity.getId());
        assertEquals(dto.getName(), entity.getName());
    }
}
