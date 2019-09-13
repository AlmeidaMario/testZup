package com.zupteste.zupTest.dto;

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

}
