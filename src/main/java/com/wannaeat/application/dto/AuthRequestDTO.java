package com.wannaeat.application.dto;

import jakarta.validation.constraints.NotBlank;

public record AuthRequestDTO(
        @NotBlank String loginId, @NotBlank String password
) {
}
