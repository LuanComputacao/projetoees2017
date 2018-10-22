package com.luancomputacao.repository;

import com.luancomputacao.domain.FaseDeEnsino;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(path = "fases-de-ensino")
public interface FaseDeEnsinoRepository extends JpaRepository<FaseDeEnsino, Integer> {

}