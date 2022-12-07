package com.example.bankapplicationrestsecurity.filter;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.crypto.SecretKey;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class JWTTokenGeneratorFilter extends OncePerRequestFilter {

    private static final String SECRET_KEY = "Zm9yIHNwcmluZyBzZWN1cml0eSBsZWFybmluZyBhcHBsaWNhdGlvbg==";

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            SecretKey key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes(StandardCharsets.UTF_8));
            String jwt = Jwts.builder()
                    .setIssuer("Bank api")
                    .setSubject("Jwt")
                    .claim("username", authentication.getName())
                    .claim("authorities", popultaeAuthorities(authentication.getAuthorities()))
                    .setIssuedAt(new Date())
                    .setExpiration(new Date(new Date().getTime() + 3000000))
                    .signWith(key).compact();

            response.setHeader(HttpHeaders.AUTHORIZATION, jwt);
        }
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        return !request.getServletPath().equals("/user");
    }


    private String popultaeAuthorities(Collection<? extends GrantedAuthority> collection){
        Set<String> authorituesSet = new HashSet<>();
        for (GrantedAuthority authority : collection){
            authorituesSet.add(authority.getAuthority());
        }

        return String.join(",", authorituesSet);
    }
}
