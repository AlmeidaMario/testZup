package com.zupteste.zuptest.service.impl;

import com.zupteste.zuptest.domain.Client;
import com.zupteste.zuptest.repository.ClientRepository;
import com.zupteste.zuptest.service.ClientService;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
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

    @Before
    public void setUp() {
        Client client = new Client((long)1,"01096709228","Amazonas");

        Mockito.when(clientRepository.findByCpf(client.getCpf()))
                .thenReturn(client);
    }

    @Test
    public void whenValidName_thenCityShouldBeFound() {
        String cpf = "01096709228";
        String name = "Mario Ferreira de Almeida Neto";

        Client clientFound = clientService.getByCPF(cpf);

        assertThat(clientFound.getName()).isEqualTo(name);
    }
}
