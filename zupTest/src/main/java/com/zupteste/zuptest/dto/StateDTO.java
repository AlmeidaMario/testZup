package com.zupteste.zuptest.dto;
import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StateDTO {//NOPMD

    private Long id;//NOPMD

    @NotBlank(message = "UF is Required")
    private String uf;//NOPMD

    @NotBlank(message = "Name is Required")
    private String name;//NOPMD

}
