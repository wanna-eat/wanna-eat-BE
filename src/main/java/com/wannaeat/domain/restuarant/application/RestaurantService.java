package com.wannaeat.domain.restuarant.application;

import com.wannaeat.domain.member.domain.Member;
import com.wannaeat.domain.restuarant.domain.dto.response.RestaurantResponse;
import com.wannaeat.domain.restuarant.infrastructure.CustomRestaurantRepository;
import com.wannaeat.domain.restuarant.infrastructure.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;
    private final CustomRestaurantRepository customRestaurantRepository;

    public Flux<RestaurantResponse> getRestaurants(int page, int size) {
        long offset = (long) page * size;
        return restaurantRepository.findAllPaged(offset, size)
                .map(RestaurantResponse::from);
    }

    public Flux<RestaurantResponse> getNearbyRestaurants(Member member, int page, int size) {
        double officeLat = 37.5665;
        double officeLon = 126.9780;

        return customRestaurantRepository.findNearbyRestaurants(officeLat, officeLon, page, size)
                .map(RestaurantResponse::from);
    }


}

