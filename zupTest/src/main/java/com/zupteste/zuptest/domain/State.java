package com.zupteste.zuptest.domain;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TB_STATE")
public class State {//NOPMD

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cd_id_state", unique = true, nullable = false)
    private Long id;//NOPMD

    @Column(name = "tx_uf", nullable = false)
    private String uf;//NOPMD

    @Column(name = "tx_name", nullable = false)
    private String name;//NOPMD

    public State(Long id){//NOPMD
        this.id = id;
    }

    public State(Long id, String name){//NOPMD
        this.id = id;
        this.name = name;
    }

}
