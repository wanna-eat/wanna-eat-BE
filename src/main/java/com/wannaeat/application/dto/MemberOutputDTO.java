package com.wannaeat.application.dto;


import com.wannaeat.domain.model.Member;

public record MemberOutputDTO(Long id) {
    public static MemberOutputDTO from(Member member) {
        return new MemberOutputDTO(member.getId());
    }
}
