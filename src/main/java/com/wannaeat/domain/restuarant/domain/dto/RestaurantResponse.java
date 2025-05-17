package com.wannaeat.domain.restuarant.domain.dto;

import com.wannaeat.domain.restuarant.domain.Restaurant;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantResponse {

    private Long id;
    private String name;
    private String foodType;
    private String openTime;
    private String closeTime;
    private Double longitude;
    private Double latitude;
    private String atmosphere;
    private String imageUrl;

    public static RestaurantResponse from(Restaurant restaurant) {
        return RestaurantResponse.builder()
                .id(restaurant.getId())
                .name(restaurant.getName())
                .foodType(restaurant.getFoodType())
                .openTime(formatTime(restaurant.getOpenTime()))
                .closeTime(formatTime(restaurant.getCloseTime()))
                .longitude(restaurant.getLongitude())
                .latitude(restaurant.getLatitude())
                .atmosphere(restaurant.getAtmosphere())
                .imageUrl(restaurant.getImageUrl())
                .build();
    }

    private static String formatTime(LocalTime time) {
        return time != null ? time.toString() : null;
    }
}
