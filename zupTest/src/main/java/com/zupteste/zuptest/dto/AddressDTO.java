package com.zupteste.zuptest.dto;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddressDTO {

    private Long id;
    private ClientDTO client;
    private Integer zipcode;
    private Integer number;
    private String street;
    private String district;
    private CityDTO city;

    public AddressDTO(Long id, Integer number, String street, String district){
        this.id = id;
        this.number = number;
        this.street = street;
        this.district = district;
    }

}
