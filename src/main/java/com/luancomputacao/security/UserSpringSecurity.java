package com.luancomputacao.security;

import com.luancomputacao.domain.enums.Perfil;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

public class UserSpringSecurity implements UserDetails {

    private static final long serialVersionUID = 1L;


    private Integer id;
    private String cpf;
    private String senha;

    public Collection<? extends GrantedAuthority> authorities;


    /**
     *
     * @param id
     * @param cpf
     * @param senha
     * @param perfilSet
     */
    public UserSpringSecurity(Integer id, String cpf, String senha, Set<Perfil> perfilSet) {
        this.id = id;
        this.cpf = cpf;
        this.senha = senha;
        this.authorities = perfilSet.stream().map(x -> new SimpleGrantedAuthority(x.getDescricao())).collect(Collectors.toList());
    }

    public Integer getId() {
        return id;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return cpf;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
