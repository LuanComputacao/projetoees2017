package com.luancomputacao.repository;

import com.luancomputacao.domain.PropostaDeInvalidacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropostaDeInvalidacaoRepository extends JpaRepository<PropostaDeInvalidacao, Integer> {

}