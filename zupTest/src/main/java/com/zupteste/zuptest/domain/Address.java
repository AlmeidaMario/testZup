package com.zupteste.zuptest.domain;

import lombok.*;
import javax.persistence.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TB_ADDRESS")
public class Address {//NOPMD

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cd_id_address", unique = true, nullable = false)
    private Long id;//NOPMD

    @JoinColumn(name = "cd_id_client")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Client client;//NOPMD

    @Column(name = "nr_zip_code", nullable = false)
    private Integer zipcode;//NOPMD

    @Column(name = "nr_number", nullable = false)
    private Integer number;//NOPMD

    @Column(name = "tx_street", nullable = false)
    private String street;//NOPMD

    @Column(name = "tx_district", nullable = false)
    private String district;//NOPMD

    @JoinColumn(name = "cd_id_city")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private City city;//NOPMD

    public Address(Long id){//NOPMD
        this.id = id;
    }

}
