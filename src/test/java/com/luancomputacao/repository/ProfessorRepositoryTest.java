package com.luancomputacao.repository;

import com.luancomputacao.domain.Professor;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ProfessorRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ProfessorRepository professorRepository;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void whenFindByCpf_thenReturnProfessor() {
        // given
        String cpf = "00011122233";
        Professor professor = new Professor(cpf, "Nome", "asdfASDF1234_.", true);
        entityManager.persist(professor);
        entityManager.flush();

        // when
        Professor found = professorRepository.findByCpf(cpf);

        // then
        assertEquals(found, professor);
    }

    @After
    public void tearDown() throws Exception {
    }
}