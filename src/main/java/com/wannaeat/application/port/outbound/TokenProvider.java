package com.wannaeat.application.port.outbound;

import io.jsonwebtoken.Claims;

public interface TokenProvider {
    String generateToken(String email);

    Claims parseToken(String token);

    boolean validateToken(String token);
}
