package com.zupteste.zuptest.service.impl;

import com.zupteste.zuptest.domain.Address;
import com.zupteste.zuptest.repository.AddressRepository;
import com.zupteste.zuptest.service.AddressService;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

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

    @Before
    public void setUp() {
        Address address = new Address((long)1,8,"Tasso da Silveira","Cidade Deus");

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
