package com.zupteste.zuptest.mapper;

import com.zupteste.zuptest.domain.State;
import com.zupteste.zuptest.dto.StateDTO;


import java.util.ArrayList;
import java.util.List;

public class StateMapper {//NOPMD

    public static List<StateDTO> convertToListDTO(final List<State> states){//NOPMD

        final List<StateDTO> stateDTOS = new ArrayList<>();

        states.forEach(state -> {
            stateDTOS.add(convertToDTO(state));
        });

        return stateDTOS;
    }

    public static List<State> convertToListEntity(final List<StateDTO> stateDTOS){//NOPMD

        final List<State> states = new ArrayList<>();

        stateDTOS.forEach(stateDTO -> {
            states.add(convertToEntity(stateDTO));
        });

        return states;
    }

    public static StateDTO convertToDTO(final State state){//NOPMD

        final StateDTO dto = new StateDTO();

        dto.setId(state.getId());
        dto.setName(state.getName());
        dto.setUf(state.getUf());
        return dto;
    }

    public static State convertToEntity(final StateDTO stateDTO){//NOPMD
        final State state = new State();

        state.setId(stateDTO.getId());
        state.setName(stateDTO.getName());
        state.setUf(stateDTO.getUf());

        return state;
    }

}
