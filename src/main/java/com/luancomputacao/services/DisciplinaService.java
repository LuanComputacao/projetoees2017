package com.luancomputacao.services;

import com.luancomputacao.domain.Disciplina;
import com.luancomputacao.repository.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DisciplinaService {

    @Autowired
    DisciplinaRepository disciplinaRepository;

    /**
     * Lista todas as disciplinas
     *
     * @return Lista de Disciplinas
     */
    public List<Disciplina> listar() {
        return disciplinaRepository.findAll();
    }

    /**
     * Encontra uma Disciplina pelo ID
     *
     * @param id ID da Disciplina
     * @return Disciplina encontrada ou Null
     */
    public Disciplina encontrar(Integer id) {
        return disciplinaRepository.findById(id).orElse(null);
    }
}
