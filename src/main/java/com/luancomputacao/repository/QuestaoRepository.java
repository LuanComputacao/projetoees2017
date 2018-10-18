package com.luancomputacao.repository;

import com.luancomputacao.domain.Questao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestaoRepository extends JpaRepository<Questao, Integer> {

    List<Questao> findByAutorCpf(@Param("cpf") String cpf);

    List<Questao> findByMateriasNome(@Param("nome") String nome);

    List<Questao> findByMateriasIdIn(@Param("ids") List<Integer> inventoryIdList);

    List<Questao> findByMateriasId(@Param("id") Integer nome);

}