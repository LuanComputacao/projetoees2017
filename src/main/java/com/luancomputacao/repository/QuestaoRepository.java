package com.luancomputacao.repository;

import com.luancomputacao.domain.Questao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestaoRepository extends JpaRepository<Questao, Integer> {

}