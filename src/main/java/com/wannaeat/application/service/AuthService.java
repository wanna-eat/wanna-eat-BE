package com.wannaeat.application.service;

import com.wannaeat.application.dto.LoginRequestDTO;
import com.wannaeat.application.dto.LoginResponseDTO;
import com.wannaeat.application.port.inbound.AuthUseCase;
import com.wannaeat.framework.adapter.outbound.security.JwtProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService implements AuthUseCase {
    private final AuthenticationManager authenticationManager;
    private final JwtProvider jwtProvider;

    public LoginResponseDTO login(LoginRequestDTO loginRequestDTO) {
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(loginRequestDTO.email(), loginRequestDTO.password());
        authenticationManager.authenticate(authenticationToken);

        String token = jwtProvider.generateToken(loginRequestDTO.email());

        return LoginResponseDTO.from(token);
    }
}
