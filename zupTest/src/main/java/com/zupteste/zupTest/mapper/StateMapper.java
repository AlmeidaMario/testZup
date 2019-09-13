package com.zupteste.zupTest.mapper;

import com.zupteste.zupTest.domain.State;
import com.zupteste.zupTest.dto.StateDTO;


import java.util.ArrayList;
import java.util.List;

public class StateMapper {

    public static List<StateDTO> convertToListDTO(List<State> states){

        List<StateDTO> stateDTOS = new ArrayList<>();

        states.forEach(state -> {
            stateDTOS.add(convertToDTO(state));
        });

        return stateDTOS;
    }

    public static StateDTO convertToDTO(State state){

        StateDTO dto = new StateDTO();

        dto.setId(state.getId());
        dto.setName(state.getName());
        dto.setUf(state.getUf());
        return dto;
    }

    public static State convertToEntity(StateDTO stateDTO){
        State state = new State();

        state.setId(stateDTO.getId());
        state.setName(stateDTO.getName());
        state.setUf(stateDTO.getUf());

        return state;
    }

}
