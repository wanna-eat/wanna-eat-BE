package com.wannaeat.domain.member.domain.dto.request;

import com.wannaeat.domain.member.domain.Member;
import com.wannaeat.domain.member.domain.dto.vo.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record MemberCreateRequest(
        @NotBlank String loginId,
        @NotBlank String password,
        @NotBlank String name,
        @NotNull Gender gender,
        @NotNull Long deptId,
        @NotNull RestaurantType restaurantType,
        @NotNull RestaurantMood restaurantMood,
        @NotNull MealType mealType,
        @NotNull RestaurantSize restaurantSize,
        @NotBlank String cafeBrand
) {
    public Member toEntity(String encodedPassword) {
        return Member.builder()
                .loginId(loginId)
                .password(encodedPassword)
                .name(name)
                .gender(gender)
                .deptId(deptId)
                .restaurantType(restaurantType)
                .restaurantMood(restaurantMood)
                .mealType(mealType)
                .restaurantSize(restaurantSize)
                .cafeBrand(cafeBrand)
                .build();
    }
}
