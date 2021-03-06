package com.luancomputacao.security;

import com.luancomputacao.utils.JWTUtil;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JWTAuthorizationFilter extends BasicAuthenticationFilter {

    private String jwtCookieName = "mr_xavier_k";

    UserDetailsService userDetailsService;
    JWTUtil jwtUtil;

    public JWTAuthorizationFilter(AuthenticationManager authenticationManager,
                                  JWTUtil jwtUtil,
                                  UserDetailsService userDetailsService) {
        super(authenticationManager);
        this.jwtUtil = jwtUtil;
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest,
                                    HttpServletResponse httpServletResponse,
                                    FilterChain filterChain)
            throws IOException, ServletException {

        String header = httpServletRequest.getHeader("Authorization");

        Cookie[] cookies = httpServletRequest.getCookies();
        Cookie jwtCookie = null;
        if (cookies != null) for (Cookie cookie : cookies)
            if (cookie.getName().equals(jwtCookieName)) jwtCookie = new Cookie(cookie.getName(), cookie.getValue());

        if (header != null && header.startsWith("Bearer ")) {
            UsernamePasswordAuthenticationToken authenticationToken = getAuthentication(httpServletRequest,
                    header.substring(7));
            if (authenticationToken != null) {
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }
        } else if (jwtCookie != null) {
            UsernamePasswordAuthenticationToken authenticationToken = getAuthentication(httpServletRequest,
                    jwtCookie.getValue());
            if (authenticationToken != null) {
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }
        }
        filterChain.doFilter(httpServletRequest, httpServletResponse);

    }

    private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest httpServletRequest,
                                                                  String jwtToken) {
        if (jwtUtil.tokenValido(jwtToken)) {
            String username = jwtUtil.getUsername(jwtToken);
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);
            return new UsernamePasswordAuthenticationToken(username, null, ((UserDetails) userDetails).getAuthorities());
        }
        return null;
    }
}
