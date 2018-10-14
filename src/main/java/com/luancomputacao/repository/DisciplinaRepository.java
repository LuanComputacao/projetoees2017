package com.luancomputacao.repository;

import com.luancomputacao.domain.Disciplina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DisciplinaRepository extends JpaRepository<Disciplina, Integer> {

    @Query("select d from Disciplina d where d.nome like ?1")
    Disciplina findByNome(String nomeDisciplina);
}