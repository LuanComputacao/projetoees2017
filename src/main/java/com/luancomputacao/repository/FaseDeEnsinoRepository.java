package com.luancomputacao.repository;

import com.luancomputacao.domain.FaseDeEnsino;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FaseDeEnsinoRepository extends JpaRepository<FaseDeEnsino, Integer> {

}