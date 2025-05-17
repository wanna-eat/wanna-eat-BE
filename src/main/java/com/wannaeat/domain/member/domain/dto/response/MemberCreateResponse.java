package com.wannaeat.domain.member.domain.dto.response;

import com.wannaeat.domain.member.domain.Member;
import jakarta.validation.constraints.NotBlank;

public record MemberCreateResponse(
        @NotBlank Long memberId,
        @NotBlank String username
) {
    public static MemberCreateResponse from(Member member) {
        return new MemberCreateResponse(member.getId(), member.getName());
    }
}
