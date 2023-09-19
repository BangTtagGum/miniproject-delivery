package com.example.miniprojectdelivery.dto;

import com.example.miniprojectdelivery.model.Menu;
import lombok.Getter;


@Getter
public class MemuResponseDto {
    public Long id;
    private Long restaurantId;
    private String image; // S3연동예정, 더미필드(임시)
    private String name;
    private int cost;

    public MemuResponseDto(Menu menu) {
        this.id = menu.getId();
        this.restaurantId = menu.getRestaurant().getId();
        this.image = menu.getImage();
        this.name = menu.getName();
        this.cost = menu.getCost();
    }
}
