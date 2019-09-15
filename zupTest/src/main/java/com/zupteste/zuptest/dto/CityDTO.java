package com.zupteste.zuptest.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CityDTO {//NOPMD

    private Long id;//NOPMD

    private StateDTO state;//NOPMD

    @NotBlank(message = "Name is Required")
    private String name;//NOPMD

    public CityDTO(Long id, String name) {//NOPMD
        this.id = id;
        this.name = name;
    }

}
