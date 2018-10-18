package com.luancomputacao.services;

import com.luancomputacao.domain.*;
import com.luancomputacao.domain.enums.Perfil;
import com.luancomputacao.domain.enums.TipoDeQuestao;
import com.luancomputacao.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Arrays;
import java.util.Collections;

@Service
public class DBTestService {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private ProfessorRepository professorRepository;
    @Autowired
    private DisciplinaRepository disciplinaRepository;
    @Autowired
    private MateriaRepository materiaRepository;
    @Autowired
    private FaseDeEnsinoRepository faseDeEnsinoRepository;
    @Autowired
    private QuestaoRepository questaoRepository;
    @Autowired
    private OpcaoDeQuestaoRepository opcaoDeQuestaoRepository;
    @Autowired
    private PropostaDeInvalidacaoRepository propostaDeInvalidacaoRepository;
    @Autowired
    private TesteRepository testeRepository;

    public void instantiateTestDataBase()  throws ParseException {

        Professor professor1 = new Professor("21817061070", "Nome1", passwordEncoder.encode("123"), Boolean.TRUE);
        professor1.addPerfil(Perfil.ADMIN);
        Professor professor2 = new Professor("94549727071", "Nome2", passwordEncoder.encode("123"), Boolean.TRUE);
        professor2.addPerfil(Perfil.MODERADOR);
        Professor professor3 = new Professor("06047128041", "Nome3", passwordEncoder.encode("123"), Boolean.TRUE);

        professorRepository.saveAll(Arrays.asList(
                professor1,
                professor2,
                professor3
        ));


        Disciplina disciplina1 = new Disciplina("Matemática");
        Disciplina disciplina2 = new Disciplina("Português");

        disciplinaRepository.saveAll(Arrays.asList(
                disciplina1,
                disciplina2
        ));

        Materia materia1 = new Materia(disciplina1, "Funções");
        Materia materia2 = new Materia(disciplina1, "Funções Compostas");
        Materia materia3 = new Materia(disciplina2, "Pretérito Perfeito");
        Materia materia4 = new Materia(disciplina2, "Sujeito Composto");

        materiaRepository.saveAll(Arrays.asList(
                materia1,
                materia2,
                materia3,
                materia4
        ));

        FaseDeEnsino faseDeEnsino1 = new FaseDeEnsino("1° ANO DO ENSINO MÉDIO REGULAR");
        FaseDeEnsino faseDeEnsino2 = new FaseDeEnsino("2° ANO DO ENSINO MÉDIO REGULAR");

        faseDeEnsinoRepository.saveAll(Arrays.asList(
                faseDeEnsino1,
                faseDeEnsino2
        ));

        Questao questao1 = new Questao(
                professor1,
                true,
                faseDeEnsino1,
                disciplina1,
                Arrays.asList(materia1, materia2),
                TipoDeQuestao.DISCURSIVA,
                (float) 1.5,
                "Calcule x+2=3"
        );
        questao1.setEspacos(3);
        Questao questao2 = new Questao(
                professor2,
                true,
                faseDeEnsino1,
                disciplina1,
                Arrays.asList(materia1, materia2),
                TipoDeQuestao.DISCURSIVA,
                (float) 3.5,
                "Calcule x+2=3"
        );
        questao2.setEspacos(5);
        Questao questao3 = new Questao(
                professor2,
                true,
                faseDeEnsino1,
                disciplina1,
                Collections.singletonList(materia4),
                TipoDeQuestao.OBJETIVA,
                (float) 2.5,
                "Escolha a afirmativa corretas"
        );

        questaoRepository.saveAll(Arrays.asList(
                questao1,
                questao2,
                questao3
        ));


        OpcaoDeQuestao opcaoDeQuestao3_1 = new OpcaoDeQuestao(questao3, "Sujeito é a pessoa principal de uma oração");
        OpcaoDeQuestao opcaoDeQuestao3_2 = new OpcaoDeQuestao(questao3, "Predicado é a pessoa principal de uma oração");
        OpcaoDeQuestao opcaoDeQuestao3_3 = new OpcaoDeQuestao(questao3, "Verbo é a pessoa principal de uma oração");
        OpcaoDeQuestao opcaoDeQuestao3_4 = new OpcaoDeQuestao(questao3, "Lalala é a pessoa principal de uma oração");
        OpcaoDeQuestao opcaoDeQuestao3_5 = new OpcaoDeQuestao(questao3, "Bla Bla Bla é a pessoa principal de uma oração");

        opcaoDeQuestaoRepository.saveAll(Arrays.asList(
                opcaoDeQuestao3_1,
                opcaoDeQuestao3_2,
                opcaoDeQuestao3_3,
                opcaoDeQuestao3_4,
                opcaoDeQuestao3_5
        ));


        PropostaDeInvalidacao propostaDeInvalidacao1 = new PropostaDeInvalidacao(
                questao1,
                professor3,
                "Deu vontade",
                "Mudar alguma coisa nela"
        );

        propostaDeInvalidacaoRepository.save(propostaDeInvalidacao1);


        Teste teste1 = new Teste(
                "Funções de primeiro e segundo graus",
                professor1,
                faseDeEnsino1,
                disciplina1,
                Arrays.asList(questao1, questao2)
        );
        testeRepository.save(teste1);

    }
}
