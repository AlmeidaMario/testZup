package com.zupteste.zuptest.dto;

import lombok.*;
import org.hibernate.validator.constraints.br.CPF;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClientDTO {//NOPMD

    private Long id;//NOPMD

    @CPF(message = "CPF Inválido")
    private String cpf;//NOPMD

    @NotBlank(message = "Name is Required")
    private String name;//NOPMD

    private Date dataNascimento;//NOPMD

    public ClientDTO(Long id, String cpf, String name){//NOPMD
        this.id = id;
        this.cpf = cpf;
        this.name = name;
    }
}
