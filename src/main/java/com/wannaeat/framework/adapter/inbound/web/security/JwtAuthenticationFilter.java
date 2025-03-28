package com.wannaeat.framework.adapter.inbound.web.security;

import com.wannaeat.application.port.outbound.TokenProvider;
import io.jsonwebtoken.Claims;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends GenericFilter {
    private final TokenProvider tokenProvider;
    private final UserDetailsService userDetailsService;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws ServletException, IOException {

        String token = resolveToken((HttpServletRequest) request);
        if (token != null && tokenProvider.validateToken(token)) {
            Claims claims = tokenProvider.parseToken(token);
            String userId = claims.getSubject();
            UserDetails userDetails = userDetailsService.loadUserByUsername(userId);

            SecurityContextHolder.getContext().setAuthentication(
                    new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities()));
        }

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        super.destroy();
    }

    private String resolveToken(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        return (bearerToken != null && bearerToken.startsWith("Bearer ")) ? bearerToken.substring(7) : null;
    }
}
