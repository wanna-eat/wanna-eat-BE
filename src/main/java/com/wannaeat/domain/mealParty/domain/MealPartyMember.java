package com.wannaeat.domain.mealParty.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("meal_party_member")
public record MealPartyMember(
        @Id Long id,
        @Column("party_id") Long partyId,
        @Column("member_id") Long memberId
) {}

