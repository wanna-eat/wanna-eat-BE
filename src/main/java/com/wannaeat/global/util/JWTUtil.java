package com.wannaeat.global.util;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.util.Base64;
import java.util.Date;

@Component
@Slf4j
public class JWTUtil {
    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expirationTime}")
    private String expirationTime;

    private SecretKey key;

    @PostConstruct
    public void init() {
        this.key = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
        log.info("JWT 비밀 키 초기화가 완료되었습니다.");
    }

    public Claims getAllClaimsFromToken(String token) {
        return Jwts.parser()
                .verifyWith(key)
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    private Long getMemberIdFromToken(String token) {
        return getAllClaimsFromToken(token).get("userPK", Long.class);
    }

    public String generateToken(Authentication authentication) {
        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
        log.info("사용자 {} 에 대한 토큰 생성", userDetails.getMemberId());
        return doGenerateToken(userDetails.getMemberId());
    }

    public Authentication getAuthentication(String token) {
        log.debug("임시 인증 토큰 생성");
        Long memberId = getMemberIdFromToken(token);
        CustomUserDetails customUserDetails = CustomUserDetails.of(memberId);
        return new UsernamePasswordAuthenticationToken(customUserDetails, null, customUserDetails.getAuthorities());
    }

    public boolean validateToken(String token) {
        try {
            getAllClaimsFromToken(token);
            log.debug("유효한 JWT 토큰 {}", token);
            return true;
        } catch (Exception e) {
            if (e instanceof SecurityException) {
                log.debug("[SecurityException] 잘못된 토큰");
                throw new JwtException("[SecurityException] 잘못된 토큰입니다.");
            } else if (e instanceof MalformedJwtException) {
                log.debug("[MalformedJwtException] 잘못된 토큰");
                throw new JwtException("[MalformedJwtException] 잘못된 토큰입니다.");
            } else if (e instanceof ExpiredJwtException) {
                log.debug("[ExpiredJwtException] 토큰 만료");
                throw new JwtException("[ExpiredJwtException] 토큰 만료");
            } else if (e instanceof UnsupportedJwtException) {
                log.debug("[UnsupportedJwtException] 잘못된 형식의 토큰");
                throw new JwtException("[UnsupportedJwtException] 잘못된 형식의 토큰");
            } else if (e instanceof IllegalArgumentException) {
                log.debug("[IllegalArgumentException]");
                throw new JwtException("[IllegalArgumentException]");
            } else {
                log.debug("[토큰검증 오류]" + e.getClass());
                throw new JwtException("[토큰검증 오류] 미처리 토큰 오류");
            }
        }
    }

    private String doGenerateToken(Long userId) {
        long expirationTimeLong = Long.parseLong(expirationTime);
        Instant now = Instant.now();
        Date createdDate = Date.from(now);
        Date expirationDate = Date.from(now.plusSeconds(expirationTimeLong));

        log.debug("JWT 토큰 생성, 만료 시간: {}", expirationDate);

        return Jwts.builder()
                .claim("userPK", userId)
                .expiration(expirationDate)
                .issuedAt(createdDate)
                .signWith(key, Jwts.SIG.HS256)
                .compact();
    }
}
