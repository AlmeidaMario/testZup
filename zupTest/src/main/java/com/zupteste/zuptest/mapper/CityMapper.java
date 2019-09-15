package com.zupteste.zuptest.mapper;

import com.zupteste.zuptest.domain.City;
import com.zupteste.zuptest.domain.State;
import com.zupteste.zuptest.dto.CityDTO;
import java.util.ArrayList;
import java.util.List;

public class CityMapper {

    public static List<CityDTO> convertToListDTO(List<City> cities){

        List<CityDTO> cityDTOS = new ArrayList<>();

        cities.forEach(city -> {
            cityDTOS.add(convertToDTO(city));
        });

        return cityDTOS;
    }

    public static List<City> convertToListEntity(List<CityDTO> cityDTOS){

        List<City> cities = new ArrayList<>();

        cityDTOS.forEach(cityDTO -> {
            cities.add(convertToEntity(cityDTO));
        });

        return cities;
    }

    public static CityDTO convertToDTO(City city){

        CityDTO dto = new CityDTO();

        dto.setId(city.getId());
        dto.setName(city.getName());

        if(city.getState() != null){
            dto.setState(StateMapper.convertToDTO(city.getState()));
        }

        return dto;
    }

    public static City convertToEntity(CityDTO cityDTO){
        City city = new City();

        city.setId(cityDTO.getId());
        city.setName(cityDTO.getName());

        if(cityDTO.getState() != null){
            city.setState(new State(cityDTO.getState().getId()));
        }

        return city;
    }

}
