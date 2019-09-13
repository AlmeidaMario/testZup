package com.zupteste.zupTest.domain;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TB_STATE")
public class State {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cd_id_state", unique = true, nullable = false)
    private Long id;

    @Column(name = "tx_uf", nullable = false)
    private String uf;

    @Column(name = "tx_name", nullable = false)
    private String name;

    public State(Long id){
        this.id = id;
    }
}
