package com.wannaeat.domain.restuarant.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalTime;

@Table("restaurant")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Restaurant {
    @Id
    private Long id;
    private String name;
    private String foodType;
    private LocalTime openTime;
    private LocalTime closeTime;
    private Double longitude;
    private Double latitude;
    private String atmosphere;
    private String imageUrl;
}
