package com.zupteste.zupTest.dto;

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

}
