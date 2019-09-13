package com.zupteste.zupTest.domain;

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
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cd_id_client", unique = true, nullable = false)
    private Long id;

    @Column(name = "nr_cpf", unique = true, nullable = false)
    private String cpf;

    @Column(name = "tx_name", nullable = false)
    private String name;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dt_data_nasc", nullable = false)
    private Date dataNascimento;

    public Client(Long id){
        this.id = id;
    }

}
