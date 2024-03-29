package com.zupteste.zuptest.repository;

import com.zupteste.zuptest.domain.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {//NOPMD

    Client findByCpf(String cpf);//NOPMD
    Client findByNameContains(String name);//NOPMD
    Page<Client> findByNameContains(Pageable pageable, String value);//NOPMD
}
