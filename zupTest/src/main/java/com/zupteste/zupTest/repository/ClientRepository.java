package com.zupteste.zupTest.repository;

import com.zupteste.zupTest.domain.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    Client findByCpf(String cpf);
    Page<Client> findByNameContains(Pageable pageable, String value);
}
