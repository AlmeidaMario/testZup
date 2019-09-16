package com.zupteste.zuptest.service.impl;

import com.zupteste.zuptest.ZupTestApplication;
import com.zupteste.zuptest.domain.City;
import com.zupteste.zuptest.repository.CityRepository;
import com.zupteste.zuptest.service.CityService;
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
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@ContextConfiguration(classes = ZupTestApplication.class)
public class CityServiceImplIntegrationTest {

    @TestConfiguration
    static class CityServiceImplTestContextConfiguration {

        @Bean
        public CityService cityService() {
            return new CityServiceImpl();
        }
    }

    @Autowired
    private CityService cityService;

    @MockBean
    private CityRepository cityRepository;

    @BeforeEach
    public void setUp() {
        City city = new City((long) 1, "Manaus");

        Mockito.when(cityRepository.findByName(city.getName()))
                .thenReturn(city);
    }

    @Test
    public void whenValidName_thenCityShouldBeFound() {
        String name = "Manaus";
        City cityFound = cityService.getByName(name);

        assertThat(cityFound.getName()).isEqualTo(name);
    }
}