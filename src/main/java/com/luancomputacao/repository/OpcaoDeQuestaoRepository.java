package com.luancomputacao.repository;

import com.luancomputacao.domain.OpcaoDeQuestao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OpcaoDeQuestaoRepository extends JpaRepository<OpcaoDeQuestao, Integer> {

}