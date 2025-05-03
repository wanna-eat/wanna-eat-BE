package com.wannaeat.infrastructure.util;

import com.wannaeat.domain.model.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

import static com.wannaeat.domain.model.MemberRole.ROLE_USER;

@Getter
@NoArgsConstructor
@ToString
public class CustomUserDetails implements UserDetails {

    private Long memberId;
    private String username;
    private String roles;
    private String password;

    public static CustomUserDetails of(Member member) {
        return new CustomUserDetails(member.getMemberId(), member.getNickname(), String.valueOf(ROLE_USER), member.getPassword());
    }

    public static CustomUserDetails of(Long memberId) {
        return new CustomUserDetails(memberId, "", String.valueOf(ROLE_USER), "");
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority(roles));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    private CustomUserDetails(Long memberId, String username, String roles, String password) {
        this.memberId = memberId;
        this.username = username;
        this.roles = roles;
        this.password = password;
    }
}