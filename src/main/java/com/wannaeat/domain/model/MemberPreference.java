package com.wannaeat.domain.model;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.List;

@Table("member_preference")
@Getter
@Builder
public class MemberPreference {

    @Id
    private Long id;

    private Long memberId;

    private List<String> preferredCategories;
    private List<String> preferredRestaurants;
    private List<String> preferredCafeBrands;
    private List<String> preferredDrinks;

    @CreatedDate
    private LocalDateTime createdDate;
    @LastModifiedDate
    private LocalDateTime modifiedDate;
}
