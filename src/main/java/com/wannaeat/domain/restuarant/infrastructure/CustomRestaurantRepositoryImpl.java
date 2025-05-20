package com.wannaeat.domain.restuarant.infrastructure;

import com.wannaeat.domain.restuarant.domain.Restaurant;
import lombok.RequiredArgsConstructor;
import org.springframework.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.time.LocalTime;

@Repository
@RequiredArgsConstructor
public class CustomRestaurantRepositoryImpl implements CustomRestaurantRepository {

    private final DatabaseClient databaseClient;

    @Override
    public Flux<Restaurant> findNearbyRestaurants(double lat, double lon, int page, int size) {
        String query = """
                    SELECT *, 
                      ST_Distance_Sphere(point(:lon, :lat), point(longitude, latitude)) AS distance
                    FROM restaurant
                    ORDER BY distance
                    LIMIT :size OFFSET :offset
                """;
        return databaseClient.sql(query)
                .bind("lat", lat)
                .bind("lon", lon)
                .bind("size", size)
                .bind("offset", page * size)
                .map((row, meta) -> new Restaurant(
                        row.get("id", Long.class),
                        row.get("name", String.class),
                        row.get("food_type", String.class),
                        row.get("open_time", LocalTime.class),
                        row.get("close_time", LocalTime.class),
                        row.get("longitude", Double.class),
                        row.get("latitude", Double.class),
                        row.get("atmosphere", String.class),
                        row.get("image_url", String.class)
                )).all();
    }
}
