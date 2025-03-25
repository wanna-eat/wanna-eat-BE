package com.wannaeat.application.dto;


import com.wannaeat.domain.model.Member;

public record MemberInputDTO(String nickname) {

    public Member toMember() {
        return new Member(nickname);
    }
}
