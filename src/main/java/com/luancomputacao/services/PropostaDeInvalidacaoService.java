package com.luancomputacao.services;

import com.luancomputacao.domain.PropostaDeInvalidacao;
import com.luancomputacao.repository.PropostaDeInvalidacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropostaDeInvalidacaoService {

    @Autowired
    PropostaDeInvalidacaoRepository propostaDeInvalidacaoRepository;


    public List<PropostaDeInvalidacao> listar() {
        return propostaDeInvalidacaoRepository.findAll();
    }

    public PropostaDeInvalidacao encontrar(Integer id) {
        return propostaDeInvalidacaoRepository.findById(id).orElse(null);
    }
}
