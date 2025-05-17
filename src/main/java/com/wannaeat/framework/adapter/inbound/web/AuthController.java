package com.wannaeat.framework.adapter.inbound.web;

import com.wannaeat.application.dto.AuthRequestDTO;
import com.wannaeat.application.dto.AuthResponseDTO;
import com.wannaeat.application.port.inbound.AuthServiceUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
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

    private final AuthServiceUseCase authServiceUseCase;

    @PostMapping("/login")
    public Mono<AuthResponseDTO> login(@Valid @RequestBody Mono<AuthRequestDTO> authRequest) {
        return authServiceUseCase.login(authRequest);
    }
}
