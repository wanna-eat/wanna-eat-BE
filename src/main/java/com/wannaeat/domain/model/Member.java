package com.wannaeat.domain.model;

import com.wannaeat.domain.vo.Role;
import jakarta.persistence.*;
import lombok.*;

import static jakarta.persistence.GenerationType.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Builder
public class Member {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String email;

    private String password;

    private String username;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;

    public void changePassword(String password) {
        this.password = password;
    }

    public static Member of(String email, String password, String username) {
        return Member.builder()
                .email(email)
                .password(password)
                .username(username)
                .role(Role.USER)
                .build();
    }

}
