package com.luancomputacao.repository;

import com.luancomputacao.domain.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.beans.Transient;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Integer> {

    @Transactional
    Professor findByCpf(String cpf);
}