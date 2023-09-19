package com.example.miniprojectdelivery.model;

import com.example.miniprojectdelivery.dto.restaurant.RestaurantRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String address;

    @OneToOne
    @JoinColumn(name = "owner_id")
    private User user;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.REMOVE)
    private List<Menu> menuList = new ArrayList<>();

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.REMOVE)
    private List<Review> reviewList = new ArrayList<>();

    public Restaurant(RestaurantRequestDto restaurantRequestDto) {
        this.name = restaurantRequestDto.getName();
        this.address = restaurantRequestDto.getAddress();
    }

    public void update(RestaurantRequestDto restaurantRequestDto) {
        this.name = restaurantRequestDto.getName();
        this.address = restaurantRequestDto.getAddress();
    }

    public void addUser(User user) {
        this.user = user;
    }
}
