package com.luancomputacao.services;

import com.luancomputacao.domain.Professor;
import com.luancomputacao.security.UserSpringSecurity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private ProfessorService professorService;

    @Override
    public UserDetails loadUserByUsername(String cpf) throws UsernameNotFoundException {
        Professor professor = professorService.encontrarPorCPF(cpf);
        if (professor == null) {
            throw new UsernameNotFoundException(cpf);
        }

        return new UserSpringSecurity(professor.getId(), professor.getCpf(), professor.getSenha(), professor.getPerfis());
    }
}
