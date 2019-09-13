package com.zupteste.zupTest.domain;


import lombok.*;
import javax.persistence.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TB_CITY")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cd_id_city", unique = true, nullable = false)
    private Long id;

    @JoinColumn(name = "cd_id_state")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private State state;

    @Column(name = "tx_name", nullable = false)
    private String name;

    public City(Long id){
        this.id = id;
    }

}