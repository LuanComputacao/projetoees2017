package com.luancomputacao.services;

import com.luancomputacao.domain.Professor;
import com.luancomputacao.repository.ProfessorRepository;
import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;

@RunWith(SpringRunner.class)
public class ProfessorServiceTest {

    private String validName = "Luan";
    private String validSenha = "9a8s7d1f8996___..asdASD";
    private String validCpf = "00011122299";

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @TestConfiguration
    static class ProfessorServiceImplTestContextConfiguration {
        @Bean
        public ProfessorService professorService(){
            return new ProfessorService();
        }

    }

    @Test
    public void realizarLogin() {
    }


    @Test
    public void test_verificaDados_clienteComNomeVazio() {
//        Assert.assertTrue(this.professorService.verificaDados(this.validCpf, "", this.validSenha));
    }
}