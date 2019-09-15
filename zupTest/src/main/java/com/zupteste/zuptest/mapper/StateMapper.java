package com.zupteste.zuptest.mapper;

import com.zupteste.zuptest.domain.State;
import com.zupteste.zuptest.dto.StateDTO;


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

    public static List<State> convertToListEntity(List<StateDTO> stateDTOS){

        List<State> states = new ArrayList<>();

        stateDTOS.forEach(stateDTO -> {
            states.add(convertToEntity(stateDTO));
        });

        return states;
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
