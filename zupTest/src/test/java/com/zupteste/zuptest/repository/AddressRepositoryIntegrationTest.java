package com.zupteste.zuptest.repository;

import com.zupteste.zuptest.domain.Address;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
public class AddressRepositoryIntegrationTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private AddressRepository addressRepository;

    @Test
    public void whenFindByName_thenReturnAddress() {

        Address address = new Address((long) 1, 8,"Tasso da Silveira","Cidade Deus");
        entityManager.persist(address);
        entityManager.flush();

        Address addressFound = addressRepository.findById(address.getId()).get();

        assertThat(addressFound.getStreet().isEmpty());
    }
}
