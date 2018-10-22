package com.luancomputacao.repository;

import com.luancomputacao.domain.PropostaDeInvalidacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(path = "propostas-de-invalidacao")
public interface PropostaDeInvalidacaoRepository extends JpaRepository<PropostaDeInvalidacao, Integer> {

}