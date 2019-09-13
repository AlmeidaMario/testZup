package com.zupteste.zupTest.mapper;

import com.zupteste.zupTest.domain.Address;
import com.zupteste.zupTest.domain.City;
import com.zupteste.zupTest.domain.Client;
import com.zupteste.zupTest.dto.AddressDTO;
import java.util.ArrayList;
import java.util.List;

public class AddressMapper {

    public static List<AddressDTO> convertToListDTO(List<Address> addresses){

        List<AddressDTO> addressDTOS = new ArrayList<>();

        addresses.forEach(address -> {
            addressDTOS.add(convertToDTO(address));
        });

        return addressDTOS;
    }

    public static AddressDTO convertToDTO(Address address){

        AddressDTO dto = new AddressDTO();

        dto.setId(address.getId());
        if(address.getClient() != null){
            dto.setClient(ClientMapper.convertToDTO(address.getClient()));
        }
        dto.setZipcode(address.getZipcode());
        dto.setNumber(address.getNumber());
        dto.setStreet(address.getStreet());
        dto.setDistrict(address.getDistrict());
        if(address.getCity() != null){
            dto.setCity(CityMapper.convertToDTO(address.getCity()));
        }

        return dto;
    }

    public static Address convertToEntity(AddressDTO addressDTO){
        Address address = new Address();
        address.setId(addressDTO.getId());
        if(addressDTO.getClient() != null){
            address.setClient(new Client(addressDTO.getClient().getId()));
        }

        address.setZipcode(addressDTO.getZipcode());
        address.setNumber(addressDTO.getNumber());
        address.setStreet(addressDTO.getStreet());
        address.setDistrict(addressDTO.getDistrict());

        if(addressDTO.getCity() != null){
            address.setCity(new City(addressDTO.getCity().getId()));
        }

        return address;
    }

}
