package com.wannaeat.domain.auth.presentation;

import com.wannaeat.domain.auth.domain.dto.request.AuthRequest;
import com.wannaeat.domain.auth.domain.dto.response.AuthResponse;
import com.wannaeat.global.util.JWTUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
@Validated
public class AuthController {
    private final JWTUtil jwtUtil;
    private final ReactiveAuthenticationManager authenticationManager;

    @PostMapping("/login")
    public Mono<AuthResponse> login(
            @Valid @RequestBody Mono<AuthRequest> authRequest) {

        return authRequest
                .flatMap(login -> this.authenticationManager
                        .authenticate(new UsernamePasswordAuthenticationToken(
                                login.loginId(), login.password()))
                        .map(this.jwtUtil::generateToken))
                .map(AuthResponse::of);
    }
}
