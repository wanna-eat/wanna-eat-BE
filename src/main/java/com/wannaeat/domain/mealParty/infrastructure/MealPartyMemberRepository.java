package com.wannaeat.domain.mealParty.infrastructure;

import com.wannaeat.domain.mealParty.domain.MealPartyMember;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface MealPartyMemberRepository extends ReactiveCrudRepository<MealPartyMember, Long> {
}
