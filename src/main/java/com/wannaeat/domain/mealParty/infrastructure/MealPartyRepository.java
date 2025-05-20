package com.wannaeat.domain.mealParty.infrastructure;

import com.wannaeat.domain.mealParty.domain.MealParty;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface MealPartyRepository extends ReactiveCrudRepository<MealParty, Long> {}

