package com.wannaeat.domain.mealParty.application;

import com.wannaeat.domain.mealParty.domain.MealParty;
import com.wannaeat.domain.mealParty.domain.MealPartyMember;
import com.wannaeat.domain.mealParty.domain.dto.request.MealPartyCreateRequest;
import com.wannaeat.domain.mealParty.infrastructure.MealPartyMemberRepository;
import com.wannaeat.domain.mealParty.infrastructure.MealPartyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class MealPartyService {

    private final MealPartyRepository mealPartyRepository;
    private final MealPartyMemberRepository mealPartyMemberRepository;

    public Mono<Void> createMealParty(MealPartyCreateRequest request) {
        MealParty mealParty = new MealParty(
                null,
                request.name(),
                request.date(),
                request.time(),
                request.restaurantId(),
                LocalDateTime.now()
        );

        return mealPartyRepository.save(mealParty)
                .flatMapMany(savedParty ->
                        Flux.fromIterable(request.memberIds())
                                .flatMap(memberId -> {
                                    MealPartyMember member = new MealPartyMember(null, savedParty.id(), memberId);
                                    return mealPartyMemberRepository.save(member);
                                })
                )
                .then();
    }
}

