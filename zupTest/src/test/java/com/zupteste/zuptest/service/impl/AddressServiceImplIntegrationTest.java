package com.zupteste.zuptest.service.impl;

import com.zupteste.zuptest.ZupTestApplication;
import com.zupteste.zuptest.domain.Address;
import com.zupteste.zuptest.domain.City;
import com.zupteste.zuptest.domain.Client;
import com.zupteste.zuptest.repository.AddressRepository;
import com.zupteste.zuptest.service.AddressService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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
public class AddressServiceImplIntegrationTest {

    @TestConfiguration
    static class AddressServiceImplTestContextConfiguration {

        @Bean
        public AddressService stateService() {
            return new AddressServiceImpl();
        }
    }

    @Autowired
    private AddressService addressService;

    @MockBean
    private AddressRepository addressRepository;

    @BeforeEach
    public void setUp() {

        Client client = new Client((long)1,"01096709228","Mario Ferreira de Almeida Neto");
        City city = new City((long) 1, "Manaus");

        Address address = new Address((long) 1, client,69099137,8,"Tasso da Silveira","Cidade Deus",city);

        Mockito.when(addressRepository.findByDistrict(address.getDistrict()))
                .thenReturn(address);
    }

    @Test
    public void whenValidDistrict_thenAddressShouldBeFound() {
        String district = "Cidade Deus";
        Address addressFound = addressService.getByDistrict(district);

        assertThat(addressFound.getDistrict()).isEqualTo(district);
    }
}
