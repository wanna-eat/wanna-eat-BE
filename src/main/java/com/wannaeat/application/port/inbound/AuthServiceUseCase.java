package com.wannaeat.application.port.inbound;

import com.wannaeat.application.dto.AuthRequestDTO;
import com.wannaeat.application.dto.AuthResponseDTO;
import reactor.core.publisher.Mono;

public interface AuthServiceUseCase {
    Mono<AuthResponseDTO> login(Mono<AuthRequestDTO> authRequestDTO);
}
