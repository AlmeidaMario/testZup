package com.zupteste.zuptest.service.impl;

import com.zupteste.zuptest.domain.State;
import com.zupteste.zuptest.repository.StateRepository;
import com.zupteste.zuptest.service.StateService;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@RunWith(SpringRunner.class)
public class StateServiceImplIntegrationTest {

    @TestConfiguration
    static class StateServiceImplTestContextConfiguration {

        @Bean
        public StateService stateService() {
            return new StateServiceImpl();
        }
    }

    @Autowired
    private StateService stateService;

    @MockBean
    private StateRepository stateRepository;

    @Before
    public void setUp() {
        State state = new State((long)1,"Amazonas");

        Mockito.when(stateRepository.findByName(state.getName()))
                .thenReturn(state);
    }

    @Test
    public void whenValidName_thenStateShouldBeFound() {
        String name = "Amazonas";
        State found = stateService.getByName(name);

        assertThat(found.getName()).isEqualTo(name);
    }


}
