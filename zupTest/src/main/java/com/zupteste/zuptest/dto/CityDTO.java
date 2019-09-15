package com.zupteste.zuptest.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CityDTO {

    private Long id;

    private StateDTO state;

    @NotBlank(message = "Name is Required")
    private String name;

    public CityDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

}
