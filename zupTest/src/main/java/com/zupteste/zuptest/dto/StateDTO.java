package com.zupteste.zuptest.dto;
import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StateDTO {

    private Long id;

    @NotBlank(message = "UF is Required")
    private String uf;

    @NotBlank(message = "Name is Required")
    private String name;

}
