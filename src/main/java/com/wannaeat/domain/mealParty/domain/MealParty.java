package com.wannaeat.domain.mealParty.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Table("meal_party")
public record MealParty(
        @Id Long id,
        String name,
        LocalDate date,
        LocalTime time,
        @Column("restaurant_id") Long restaurantId,
        @Column("created_at") LocalDateTime createdAt
) {}
