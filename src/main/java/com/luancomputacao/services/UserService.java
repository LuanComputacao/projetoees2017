package com.luancomputacao.services;

import org.springframework.security.core.context.SecurityContextHolder;

public class UserService {


    public static String authenticated() {
        try {
            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            System.out.println(principal);
            return principal != "anonymousUser" ? (String) principal : null;
        } catch (Exception e) {
            return null;
        }
    }
}

