package com.example.miniprojectdelivery.dto;

import lombok.Getter;

@Getter
public class RestaurantResponseDto {
    private Long id;
//    private String owner;
    private String name;
    private String address;

    public RestaurantResponseDto(Restaurant restaurant) {
        this.id = restaurant.getId();
//        this.owner = restaurant.getOwner();
        this.name = restaurant.getName();
        this.address = restaurant.getAddress();
    }
}
