package com.zupteste.zuptest.mapper;

import com.zupteste.zuptest.domain.State;
import com.zupteste.zuptest.dto.StateDTO;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StateMapperTest {

    @Test
    void convertDtoToEntity() {
        StateDTO dto = new StateDTO((long) 1,"AM","Amazonas");
        State entity = StateMapper.convertToEntity(dto);
        checkProperties(dto, entity);
    }

    @Test
    void convertEntityToDto() {
        State entity = new State((long) 1, "AM", "Amazonas");
        StateDTO dto = StateMapper.convertToDTO(entity);
        checkProperties(dto, entity);
    }


    @Test
    void convertListToEntityList() {
        StateDTO dto1 = new StateDTO((long) 1, "AM", "Amazonas");
        StateDTO dto2 = new StateDTO((long) 2,"PR","Paraná");
        List<StateDTO> listDTOS = Arrays.asList(dto1, dto2);

        final List<State> entities = StateMapper.convertToListEntity(listDTOS);
        assertEquals(listDTOS.size(), entities.size());
        for (int i = 0; i < entities.size(); i++) {
            checkProperties(listDTOS.get(i), entities.get(i));
        }
    }

    @Test
    void convertListToDtoList() {
        State entity1 = new State((long) 1, "AM", "Amazonas");
        State entity2 = new State((long) 2,"PR","Paraná");
        List<State> entities = Arrays.asList(entity1, entity2);
        final List<StateDTO> listDTOS = StateMapper.convertToListDTO(entities);

        assertEquals(entities.size(), listDTOS.size());

        for (int i = 0; i < listDTOS.size(); i++) {
            checkProperties(listDTOS.get(i), entities.get(i));
        }
    }

    private void checkProperties(StateDTO dto, State entity) {
        assertEquals(dto.getId(), entity.getId());
        assertEquals(dto.getUf(), entity.getUf());
        assertEquals(dto.getName(), entity.getName());
    }
}
