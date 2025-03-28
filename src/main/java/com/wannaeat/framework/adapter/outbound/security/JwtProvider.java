package com.wannaeat.framework.adapter.outbound.security;

import com.wannaeat.application.port.outbound.TokenProvider;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

@Component
public class JwtProvider implements TokenProvider {
    private final SecretKey secretKey;
    private final static long expirationMs = 1000 * 60 * 60; // 1시간

    public JwtProvider() {
        String secret = "your-very-strong-secret-key-should-be-long-enough"; // 충분히 긴 키 필요
        this.secretKey = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
    }

    @Override
    public String generateToken(String email) {
        return Jwts.builder()
                .subject(email)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + expirationMs))
                .signWith(secretKey)
                .compact();
    }

    @Override
    public Claims parseToken(String token) {
        return (Claims) Jwts.parser().verifyWith(secretKey).build()
                .parseSignedClaims(token);
    }

    @Override
    public boolean validateToken(String token) {
        try {
            parseToken(token);
            return true;
        } catch (JwtException e) {
            return false;
        }
    }
}