package com.wannaeat.domain.member.domain;

import com.wannaeat.domain.member.domain.dto.vo.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import lombok.*;

@Table(name = "member") // 실제 테이블명이 'member'이므로 소문자 사용
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Member {

    @Id
    private Long id;

    private String loginId;

    private String password;

    private String name;

    private Gender gender; // Enum 저장은 String 기반 수동 처리 필요

    private Long deptId;

    private RestaurantType restaurantType;
    private RestaurantMood restaurantMood;
    private MealType mealType;
    private RestaurantSize restaurantSize;

    private String cafeBrand;
}
