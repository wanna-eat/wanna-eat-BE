package com.wannaeat.domain.restuarant.infrastructure;

import com.wannaeat.domain.restuarant.domain.Restaurant;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface RestaurantRepository extends ReactiveCrudRepository<Restaurant, Long> {

    @Query("SELECT * FROM restaurant OFFSET :offset LIMIT :limit")
    Flux<Restaurant> findAllPaged(long offset, int limit);
}

