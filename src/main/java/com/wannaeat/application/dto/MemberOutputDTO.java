package com.wannaeat.application.dto;


import com.wannaeat.domain.model.Member;

public record MemberOutputDTO(Long id, String nickname) {
    public static MemberOutputDTO from(Member member) {
        return new MemberOutputDTO(member.getId(), member.getUsername());
    }
}
