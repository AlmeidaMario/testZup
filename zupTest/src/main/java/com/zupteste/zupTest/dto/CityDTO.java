package com.zupteste.zupTest.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CityDTO {

    private Long id;
    private StateDTO state;
    private String name;

}
