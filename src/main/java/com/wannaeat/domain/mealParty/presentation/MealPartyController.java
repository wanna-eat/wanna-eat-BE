package com.wannaeat.domain.mealParty.presentation;

import com.wannaeat.domain.mealParty.application.MealPartyService;
import com.wannaeat.domain.mealParty.domain.dto.request.MealPartyCreateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/meal-party")
@RequiredArgsConstructor
public class MealPartyController {

    private final MealPartyService mealPartyService;

    @PostMapping
    public Mono<ResponseEntity<Void>> createMealParty(@RequestBody MealPartyCreateRequest request) {
        return mealPartyService.createMealParty(request)
                .thenReturn(ResponseEntity.status(HttpStatus.CREATED).build());
    }
}
