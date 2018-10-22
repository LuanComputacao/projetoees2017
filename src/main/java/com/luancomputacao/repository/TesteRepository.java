package com.luancomputacao.repository;

import com.luancomputacao.domain.Teste;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(path = "testes")
public interface TesteRepository extends JpaRepository<Teste, Integer> {

}