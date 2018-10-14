package com.luancomputacao.resource.rest;

import com.luancomputacao.security.UserSpringSecurity;
import com.luancomputacao.services.UserService;
import com.luancomputacao.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(value = "/auth")
public class AuthResource {

    @Autowired
    private JWTUtil jwtUtil;

    @PostMapping(value = "/refresh-token")
    public ResponseEntity<Void> refreshToken(HttpServletResponse response) {
        UserSpringSecurity userSS = UserService.autenticated();
        String token = jwtUtil.generateToken(userSS.getUsername());
        response.addHeader("Authorization", "Bearer " + token);
        return ResponseEntity.noContent().build();
    }

}
