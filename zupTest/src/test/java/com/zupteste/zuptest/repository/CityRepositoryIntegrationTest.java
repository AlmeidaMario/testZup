package com.zupteste.zuptest.repository;

import com.zupteste.zuptest.domain.City;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
public class CityRepositoryIntegrationTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private CityRepository cityRepository;

    @Test
    public void whenFindByName_thenReturnCity() {

        City city = new City((long) 1, "Manaus");
        entityManager.persist(city);
        entityManager.flush();

        City cityFound = cityRepository.findById(city.getId()).get();

        assertThat(cityFound.getName()).isEqualTo(city.getName());
    }
}
