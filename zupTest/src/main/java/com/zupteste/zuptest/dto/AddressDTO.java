package com.zupteste.zuptest.dto;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddressDTO {//NOPMD

    private Long id;//NOPMD
    private ClientDTO client;//NOPMD
    private Integer zipcode;//NOPMD
    private Integer number;//NOPMD
    private String street;//NOPMD
    private String district;//NOPMD
    private CityDTO city;//NOPMD

    public AddressDTO(Long id, Integer number, String street, String district){//NOPMD
        this.id = id;
        this.number = number;
        this.street = street;
        this.district = district;
    }

}
