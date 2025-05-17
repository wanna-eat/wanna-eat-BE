package com.wannaeat.domain.restuarant.application;

import com.wannaeat.domain.restuarant.domain.dto.RestaurantResponse;
import com.wannaeat.domain.restuarant.infrastructure.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;

    public Flux<RestaurantResponse> getRestaurants(int page, int size) {
        long offset = (long) page * size;
        return restaurantRepository.findAllPaged(offset, size)
                .map(RestaurantResponse::from);
    }
}

