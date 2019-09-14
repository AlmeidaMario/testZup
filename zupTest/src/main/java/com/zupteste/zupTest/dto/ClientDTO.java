package com.zupteste.zupTest.dto;

import lombok.*;
import org.hibernate.validator.constraints.br.CPF;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClientDTO {

    private Long id;

    @CPF(message = "CPF Inválido")
    private String cpf;

    @NotBlank(message = "Name is Required")
    private String name;

    private Date dataNascimento;

    public ClientDTO(Long id, String cpf, String name){
        this.id = id;
        this.cpf = cpf;
        this.name = name;
    }
}
