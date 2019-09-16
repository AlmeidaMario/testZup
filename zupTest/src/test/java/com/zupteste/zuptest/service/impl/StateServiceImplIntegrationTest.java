package com.zupteste.zuptest.service.impl;

import com.zupteste.zuptest.ZupTestApplication;
import com.zupteste.zuptest.domain.State;
import com.zupteste.zuptest.repository.StateRepository;
import com.zupteste.zuptest.service.StateService;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.ContextConfiguration;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@SpringBootTest
@ContextConfiguration(classes = ZupTestApplication.class)
public class StateServiceImplIntegrationTest {

    @TestConfiguration
    public static class StateServiceImplTestContextConfiguration {

        @Bean
        public StateService stateService() {
            return new StateServiceImpl();
        }
    }

    @Autowired
    StateService stateService;
    @MockBean
    StateRepository stateRepository;

    @BeforeEach
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
