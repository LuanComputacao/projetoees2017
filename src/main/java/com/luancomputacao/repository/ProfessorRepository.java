package com.luancomputacao.repository;

import com.luancomputacao.domain.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Integer> {

    Professor findByCpf(String cpf);
}