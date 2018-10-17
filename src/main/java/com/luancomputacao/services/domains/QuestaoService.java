package com.luancomputacao.services.domains;

import com.luancomputacao.domain.Questao;
import com.luancomputacao.repository.QuestaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestaoService {

    @Autowired
    private QuestaoRepository questaoRepository;

    public Questao encontrar(Integer id) {
        return questaoRepository.findById(id).orElse(null);
    }


    public List<Questao> listar() {
        return questaoRepository.findAll();
    }
}
