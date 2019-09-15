package com.zupteste.zuptest.mapper;

import com.zupteste.zuptest.domain.City;
import com.zupteste.zuptest.domain.State;
import com.zupteste.zuptest.dto.CityDTO;
import java.util.ArrayList;
import java.util.List;

public class CityMapper {//NOPMD

    public static List<CityDTO> convertToListDTO(final List<City> cities){//NOPMD

        final List<CityDTO> cityDTOS = new ArrayList<>();

        cities.forEach(city -> {
            cityDTOS.add(convertToDTO(city));
        });

        return cityDTOS;
    }

    public static List<City> convertToListEntity(final List<CityDTO> cityDTOS){//NOPMD

        final List<City> cities = new ArrayList<>();

        cityDTOS.forEach(cityDTO -> {
            cities.add(convertToEntity(cityDTO));
        });

        return cities;
    }

    public static CityDTO convertToDTO(final City city){//NOPMD

        final CityDTO dto = new CityDTO();

        dto.setId(city.getId());
        dto.setName(city.getName());

        if(city.getState() != null){
            dto.setState(StateMapper.convertToDTO(city.getState()));
        }

        return dto;
    }

    public static City convertToEntity(final CityDTO cityDTO){//NOPMD
        final City city = new City();

        city.setId(cityDTO.getId());
        city.setName(cityDTO.getName());

        if(cityDTO.getState() != null){
            city.setState(new State(cityDTO.getState().getId()));//NOPMD
        }

        return city;
    }

}
