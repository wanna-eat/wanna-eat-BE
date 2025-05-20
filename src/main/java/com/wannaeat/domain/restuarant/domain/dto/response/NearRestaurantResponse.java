package com.wannaeat.domain.restuarant.domain.dto.response;

import com.wannaeat.domain.restuarant.domain.Restaurant;

import java.util.List;

public record NearRestaurantResponse(
        Long id,
        String name,
        String imageUrl,
        String address,          // 주소는 reverse geocoding으로 변환되었다고 가정
        List<String> tags        // 음식 종류 + 분위기
) {
    public static NearRestaurantResponse from(Restaurant restaurant) {
        return new NearRestaurantResponse(
                restaurant.getId(),
                restaurant.getName(),
                restaurant.getImageUrl(),
                convertCoordinatesToAddress(restaurant.getLatitude(), restaurant.getLongitude()),  // 실제 서비스에서는 외부 API 활용
                List.of(restaurant.getFoodType(), restaurant.getAtmosphere())
        );
    }

    private static String convertCoordinatesToAddress(Double lat, Double lon) {
        // TODO 위치 변환 기능 구현
        return "서울시 종로구";
    }
}
