package com.luancomputacao.services;

import com.luancomputacao.domain.Professor;
import com.luancomputacao.repository.ProfessorRepository;
import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.Matchers.instanceOf;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProfessorServiceTest {

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Autowired
    @Spy
    private ProfessorService professorService;

    @Mock
    private ProfessorRepository mockProfessorRepository;

    private String cpfValido = "70481563172";
    private String senhaValida = "Aaaa.1234";

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void contextLoads() throws Exception {
    }

    @Test
    public void realizarLogin() {
    }

    @Test
    public void validaNome_nomeInvalido() {
        Assert.assertFalse(professorService.validaNome("a"));
    }

    @Test
    public void validaNome_nomeValido() {
        Assert.assertTrue(professorService.validaNome("Le"));
    }


    @Test
    public void validaCPF_cpfInvalido() {
        Assert.assertFalse(professorService.validaCpf("00000000000"));
    }

    @Test
    public void validaCPF_cpfValido() {
        Assert.assertTrue(professorService.validaCpf(this.cpfValido));
    }

    @Test
    public void validaSenha_senhaInvalida() {
        Assert.assertFalse(professorService.validaSenha("aaaaaaaa"));
    }

    @Test
    public void validaSenha_senhaValida() {
        Assert.assertTrue(professorService.validaSenha(this.senhaValida));
    }


    @Test
    public void verificaDados_professorComCpfInvalido() {
        doReturn(false).when(professorService).validaCpf(any(String.class));
        doReturn(true).when(professorService).validaNome(any(String.class));
        doReturn(true).when(professorService).validaSenha(any(String.class));
        Assert.assertFalse(professorService.verificaDados("", "", ""));
    }

    @Test
    public void verificaDados_professorComNomeInvalido() {
        doReturn(true).when(professorService).validaCpf(any(String.class));
        doReturn(false).when(professorService).validaNome(any(String.class));
        doReturn(true).when(professorService).validaSenha(any(String.class));
        Assert.assertFalse(professorService.verificaDados("", "", ""));
    }

    @Test
    public void verificaDados_professorComSenhaInvalida() {
        doReturn(true).when(professorService).validaCpf(any(String.class));
        doReturn(true).when(professorService).validaNome(any(String.class));
        doReturn(false).when(professorService).validaSenha(any(String.class));
        Assert.assertFalse(professorService.verificaDados("", "", ""));
    }


    @Test
    public void verificaDados_professorComDadosValidos() {
        String nome = "Nome";
        String cpf = this.cpfValido;
        String senha = this.senhaValida;
        Assert.assertTrue(professorService.verificaDados(cpf, nome, senha));
    }

    @Test
    public void criarModerador_dadosInvalidos() {
        doReturn(false)
                .when(this.professorService)
                .verificaDados(any(String.class), any(String.class), any(String.class));
        Assert.assertNull(this.professorService.criarModerador(cpfValido, "Nome", senhaValida));
    }

    @Test
    @DirtiesContext
    public void criaModerador_dadosValidos() {
        doReturn(true)
                .when(this.professorService)
                .verificaDados(any(String.class), any(String.class), any(String.class));

        when(this.mockProfessorRepository.save(any(Professor.class)))
                .thenReturn(new Professor("", "", "", true));

        Professor professor = this.professorService.criarModerador(cpfValido, "Nome", senhaValida);
        Assert.assertThat(professor, instanceOf(Professor.class));
        Assert.assertTrue(professor.getModerador());
    }

    @Test
    public void criarProfessor_dadosInvalidos() {
        doReturn(false)
                .when(this.professorService)
                .verificaDados(any(String.class), any(String.class), any(String.class));
        Assert.assertNull(this.professorService.criarProfessor(cpfValido, "Nome", senhaValida));
    }

    @Test
    @DirtiesContext
    public void criaProfessor_dadosValidos() {
        doReturn(true)
                .when(this.professorService)
                .verificaDados(any(String.class), any(String.class), any(String.class));

        when(this.mockProfessorRepository.save(any(Professor.class)))
                .thenReturn(new Professor("", "", "", false));

        Professor professor = this.professorService.criarProfessor(cpfValido, "Nome", senhaValida);
        Assert.assertThat(professor, instanceOf(Professor.class));
        Assert.assertFalse(professor.getModerador());
    }

}