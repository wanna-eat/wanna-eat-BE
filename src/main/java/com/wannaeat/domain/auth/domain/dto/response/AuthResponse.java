package com.wannaeat.domain.auth.domain.dto.response;

import jakarta.validation.constraints.NotBlank;

public record AuthResponse(
        @NotBlank String accessToken
) {
    public static AuthResponse of(@NotBlank String accessToken) {
        return new AuthResponse(accessToken);
    }
}