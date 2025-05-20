package com.wannaeat.domain.restuarant.infrastructure;

import com.wannaeat.domain.restuarant.domain.Restaurant;
import reactor.core.publisher.Flux;

public interface CustomRestaurantRepository {
    Flux<Restaurant> findNearbyRestaurants(double lat, double lon, int page, int size);
}
