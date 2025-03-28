package com.wannaeat.application.dto;

public record LoginResponseDTO(String token) {

    public static LoginResponseDTO from(String token) {
        return new LoginResponseDTO(token);
    }
}
