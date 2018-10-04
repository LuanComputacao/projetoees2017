package com.luancomputacao.services;

import com.luancomputacao.domain.Materia;
import com.luancomputacao.repository.MateriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MateriaService {

    @Autowired
    private MateriaRepository materiaRepository;

    public Materia encontrar(Integer id) {
        return materiaRepository.findById(id).orElse(null);
    }


    public List<Materia> listar() {
        return materiaRepository.findAll();
    }
}
