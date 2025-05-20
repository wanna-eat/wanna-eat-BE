package com.wannaeat.domain.restuarant.presentation;

import com.wannaeat.domain.member.domain.Member;
import com.wannaeat.domain.restuarant.application.RestaurantService;
import com.wannaeat.domain.restuarant.domain.dto.response.RestaurantResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/v1/restaurants")
@RequiredArgsConstructor
public class RestaurantController {

    private final RestaurantService restaurantService;

    @GetMapping
    public Flux<RestaurantResponse> getRestaurants(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        return restaurantService.getRestaurants(page, size);
    }

    @GetMapping("/nearby")
    public Flux<RestaurantResponse> getNearbyRestaurants(
            @AuthenticationPrincipal Member member,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        return restaurantService.getNearbyRestaurants(member, page, size);
    }
}
