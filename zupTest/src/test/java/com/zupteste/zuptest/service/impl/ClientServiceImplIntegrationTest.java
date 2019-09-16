package com.zupteste.zuptest.service.impl;

import com.zupteste.zuptest.ZupTestApplication;
import com.zupteste.zuptest.domain.Client;
import com.zupteste.zuptest.repository.ClientRepository;
import com.zupteste.zuptest.service.ClientService;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.ContextConfiguration;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@ContextConfiguration(classes = ZupTestApplication.class)
public class ClientServiceImplIntegrationTest {

    @TestConfiguration
    static class ClientServiceImplTestContextConfiguration {
        @Bean
        public ClientService clientService() {
            return new ClientServiceImpl();
        }
    }

    @Autowired
    private ClientService clientService;

    @MockBean
    private ClientRepository clientRepository;

    @BeforeEach
    public void setUp() {
        Client client = new Client((long)1,"01096709228","Mario Ferreira de Almeida Neto");

        Mockito.when(clientRepository.findByCpf(client.getCpf()))
                .thenReturn(client);
        Mockito.when(clientRepository.findByNameContains(client.getName()))
                .thenReturn(client);
    }

    @Test
    public void whenValidName_thenCityShouldBeFound() {
        String name = "Mario Ferreira de Almeida Neto";
        String cpf = "01096709228";

        Client clientFound = clientService.getByCPF(cpf);

        assertThat(clientFound.getName()).isEqualTo(name);
    }
}
