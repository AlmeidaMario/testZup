package com.zupteste.zuptest.repository;

import com.zupteste.zuptest.domain.Client;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
public class ClientRepositoryIntegrationTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ClientRepository clientRepository;

    @Test
    public void whenFindByName_thenReturnClient() {

        Client client = new Client((long) 1, "01096709228","Mario Ferreira de Almeida Neto");
        entityManager.persist(client);
        entityManager.flush();

        Client clientFound = clientRepository.findById(client.getId()).get();

        assertThat(clientFound.getName()).isEqualTo(client.getName());
    }
}
