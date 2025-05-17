package com.wannaeat.application.dto;

import com.wannaeat.domain.model.Member;
import com.wannaeat.domain.model.MemberPreference;

import java.util.List;

public record MemberInputDTO(
        String email,
        String password,
        String agreement,
        String nickname,
        String gender,
        Long deptId,
        List<String> preferredCategories,
        List<String> preferredRestaurants,
        List<String> preferredCafeBrands,
        List<String> preferredDrinks
) {
    public Member toMember() {
        return Member.builder()
                .loginId(email)
                .password(password)
                .nickname(nickname)
                .gender(gender)
                .deptId(deptId)
                .build();
    }

    public MemberPreference toPreference(Long memberId) {
        return MemberPreference.builder()
                .memberId(memberId)
                .preferredCategories(preferredCategories)
                .preferredRestaurants(preferredRestaurants)
                .preferredCafeBrands(preferredCafeBrands)
                .preferredDrinks(preferredDrinks)
                .build();
    }
}
