package com.luancomputacao.repository;


import com.luancomputacao.domain.ProfessorUtilizaTeste;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorUtilizaTesteRepository extends JpaRepository<ProfessorUtilizaTeste, Integer> {

}