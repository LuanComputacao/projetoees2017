package com.luancomputacao.repository;

import com.luancomputacao.domain.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;

@Repository
@RepositoryRestResource(path = "professores")
public interface ProfessorRepository extends JpaRepository<Professor, Integer> {

    @Query("select p from Professor p where p.cpf = ?1")
    Professor findByCpf(String cpf);

    @Query("select p from Professor p where p.cpf = ?1")
    Professor findByCpf(String cpf, Pageable pageable);

    Professor findOneByCpf(String cpf);
}