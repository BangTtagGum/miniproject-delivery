package com.example.miniprojectdelivery.dto;

import lombok.Getter;

@Getter
public class MenuRequestDto {
    private Long restaurantId;
    private String image; // S3연동예정, 더미필드(임시)
    private String name;
    private int cost;
}
