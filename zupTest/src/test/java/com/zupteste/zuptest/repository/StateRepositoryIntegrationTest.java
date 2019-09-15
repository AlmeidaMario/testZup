package com.zupteste.zuptest.repository;

import com.zupteste.zuptest.domain.State;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@DataJpaTest
public class StateRepositoryIntegrationTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private StateRepository stateRepository;

    @Test
    public void whenFindByName_thenReturnState() {

        State state = new State((long) 1, "Amazonas");
        entityManager.persist(state);
        entityManager.flush();

        State stateFound = stateRepository.findById(state.getId()).get();

        assertThat(stateFound.getName()).isEqualTo(state.getName());
    }

}
