package com.zupteste.zuptest.domain;

import lombok.*;
import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TB_CLIENT")
@Entity
public class Client {//NOPMD

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cd_id_client", unique = true, nullable = false)
    private Long id;//NOPMD

    @Column(name = "nr_cpf", unique = true, nullable = false)
    private String cpf;//NOPMD

    @Column(name = "tx_name", nullable = false)
    private String name;//NOPMD

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dt_data_nasc", nullable = false)
    private Date dataNascimento;//NOPMD

    public Client(Long id){//NOPMD
        this.id = id;
    }

    public Client(final String name){//NOPMD
        this.name = name;
    }

    public Client(Long id, String cpf, String name){//NOPMD
        this.id = id;
        this.cpf = cpf;
        this.name = name;
    }
}
