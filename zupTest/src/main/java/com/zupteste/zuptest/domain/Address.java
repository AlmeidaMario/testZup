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
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cd_id_address", unique = true, nullable = false)
    private Long id;

    @JoinColumn(name = "cd_id_client")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Client client;

    @Column(name = "nr_zip_code", nullable = false)
    private Integer zipcode;

    @Column(name = "nr_number", nullable = false)
    private Integer number;

    @Column(name = "tx_street", nullable = false)
    private String street;

    @Column(name = "tx_district", nullable = false)
    private String district;

    @JoinColumn(name = "cd_id_city")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private City city;

    public Address(Long id){
        this.id = id;
    }

    public Address(Long id, Integer number, String street, String district){
        this.id = id;
        this.number = number;
        this.street = street;
        this.district = district;
    }

}
