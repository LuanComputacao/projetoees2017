package com.luancomputacao.services.domains;

import com.luancomputacao.domain.Professor;
import com.luancomputacao.domain.PropostaDeInvalidacao;
import com.luancomputacao.domain.Questao;
import com.luancomputacao.dto.PropostaDeInvalidacaoDAO;
import com.luancomputacao.repository.PropostaDeInvalidacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropostaDeInvalidacaoService {

    @Autowired
    PropostaDeInvalidacaoRepository propostaDeInvalidacaoRepository;

    @Autowired
    QuestaoService questaoService;

    @Autowired
    ProfessorService professorService;

    public List<PropostaDeInvalidacao> listar() {
        return propostaDeInvalidacaoRepository.findAll();
    }

    public PropostaDeInvalidacao encontrar(Integer id) {
        return propostaDeInvalidacaoRepository.findById(id).orElse(null);
    }

    public PropostaDeInvalidacao criar(PropostaDeInvalidacaoDAO propostaDAO) {
        Questao questao = questaoService.encontrar(propostaDAO.getQuestaoID());
        Professor professor = professorService.encontrar(propostaDAO.getProfessorID());

        PropostaDeInvalidacao propostaDeInvalidacao = new PropostaDeInvalidacao(
                questao,
                professor,
                propostaDAO.getJustificativa(),
                propostaDAO.getProposta()
        );

        PropostaDeInvalidacao propostaDeInvalidacao1 = propostaDeInvalidacaoRepository.save(propostaDeInvalidacao);
        return propostaDeInvalidacao1;
    }
}
