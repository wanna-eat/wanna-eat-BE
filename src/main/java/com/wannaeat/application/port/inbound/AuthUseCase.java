package com.wannaeat.application.port.inbound;

import com.wannaeat.application.dto.LoginRequestDTO;
import com.wannaeat.application.dto.LoginResponseDTO;

public interface AuthUseCase {
    LoginResponseDTO login(LoginRequestDTO loginRequestDTO);
}
