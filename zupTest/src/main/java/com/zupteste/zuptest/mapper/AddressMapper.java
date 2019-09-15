package com.zupteste.zuptest.mapper;

import com.zupteste.zuptest.domain.Address;
import com.zupteste.zuptest.domain.City;
import com.zupteste.zuptest.domain.Client;
import com.zupteste.zuptest.dto.AddressDTO;
import java.util.ArrayList;
import java.util.List;

public class AddressMapper {//NOPMD

    public static List<AddressDTO> convertToListDTO(final List<Address> addresses){//NOPMD

        final List<AddressDTO> addressDTOS = new ArrayList<>();

        addresses.forEach(address -> {
            addressDTOS.add(convertToDTO(address));
        });

        return addressDTOS;
    }

    public static List<Address> convertToListEntity(final List<AddressDTO> addressDTOS){//NOPMD

        final List<Address> addresses = new ArrayList<>();

        addressDTOS.forEach(addressDTO -> {
            addresses.add(convertToEntity(addressDTO));
        });

        return addresses;
    }

    public static AddressDTO convertToDTO(final Address address){//NOPMD

        final AddressDTO dto = new AddressDTO();

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

    public static Address convertToEntity(final AddressDTO addressDTO){//NOPMD
        final Address address = new Address();
        address.setId(addressDTO.getId());
        if(addressDTO.getClient() != null){
            address.setClient(new Client(addressDTO.getClient().getId()));//NOPMD
        }

        address.setZipcode(addressDTO.getZipcode());
        address.setNumber(addressDTO.getNumber());
        address.setStreet(addressDTO.getStreet());
        address.setDistrict(addressDTO.getDistrict());

        if(addressDTO.getCity() != null){
            address.setCity(new City(addressDTO.getCity().getId()));//NOPMD
        }

        return address;
    }

}
