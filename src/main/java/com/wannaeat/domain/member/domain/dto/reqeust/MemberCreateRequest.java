package com.wannaeat.domain.member.domain.dto.reqeust;

import com.wannaeat.domain.member.domain.Member;
import jakarta.validation.constraints.NotBlank;

public record MemberCreateRequest(@NotBlank String loginId, @NotBlank String password, Long deptId,
                                  @NotBlank String nickname, String gender, String image, Long companyId) {

    public Member toMember(final String password) {
        return Member.builder()
                .loginId(loginId)
                .password(password)
                .deptId(deptId)
                .nickname(nickname)
                .gender(gender)
                .image(image)
                .companyId(companyId)
                .build();
    }
}
