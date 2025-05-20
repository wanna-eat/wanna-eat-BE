package com.wannaeat.domain.mealParty.domain.dto.request;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public record MealPartyCreateRequest(
        String name,
        LocalDate date,
        LocalTime time,
        List<Long> memberIds,
        Long restaurantId
) {}

