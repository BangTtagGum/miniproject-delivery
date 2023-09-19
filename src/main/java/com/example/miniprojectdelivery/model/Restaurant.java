package com.example.miniprojectdelivery.model;

import com.example.miniprojectdelivery.dto.RestaurantRequestDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "restaurant")
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String address;

    //@OneToOne
    //@JoinColumn(name = "owner_id")
    //private String owner;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.REMOVE)
    private List<Menu> menuList = new ArrayList<>();

    public Restaurant(RestaurantRequestDto restaurantRequestDto) {
        //this.owner = restaurantRequestDto.getOwner();
        this.name = restaurantRequestDto.getName();
        this.address = restaurantRequestDto.getAddress();
    }

    public void update(RestaurantRequestDto restaurantRequestDto) {
        //this.owner = restaurantRequestDto.getOwner();
        this.name = restaurantRequestDto.getName();
        this.address = restaurantRequestDto.getAddress();
    }
}
