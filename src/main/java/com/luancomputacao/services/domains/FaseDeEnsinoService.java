package com.luancomputacao.services.domains;

import com.luancomputacao.domain.FaseDeEnsino;
import com.luancomputacao.repository.FaseDeEnsinoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FaseDeEnsinoService {

    @Autowired
    FaseDeEnsinoRepository faseDeEnsinoRepository;

    public List<FaseDeEnsino> listar() {
        return faseDeEnsinoRepository.findAll();
    }
}
