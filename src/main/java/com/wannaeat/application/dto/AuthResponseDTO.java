package com.wannaeat.application.dto;

import jakarta.validation.constraints.NotBlank;

public record AuthResponseDTO(
        @NotBlank String accessToken
) {
    public static AuthResponseDTO of(@NotBlank String accessToken) {
        return new AuthResponseDTO(accessToken);
    }
}
