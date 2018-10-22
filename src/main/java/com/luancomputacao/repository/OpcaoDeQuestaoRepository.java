package com.luancomputacao.repository;

import com.luancomputacao.domain.OpcaoDeQuestao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(path = "opcoes-de-questao")
public interface OpcaoDeQuestaoRepository extends JpaRepository<OpcaoDeQuestao, Integer> {

}