package com.example.miniprojectdelivery.model;

import com.example.miniprojectdelivery.dto.MenuRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "menu")
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne   // Restaurant에서 @OneToMany 필요함
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    @Column(nullable = false)
    private String image;  // S3연동예정, 더미필드(임시)
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private int cost;

    public Menu(MenuRequestDto requestDto, Restaurant restaurant) {
        this.id = getId();
        this.restaurant = restaurant; // 임의 Restaurant 생성
        this.image = requestDto.getImage();
        this.name = requestDto.getName();
        this.cost = requestDto.getCost();
    }


    public void update(MenuRequestDto requestDto) {
        this.image = requestDto.getImage();
        this.name = requestDto.getName();
        this.cost = requestDto.getCost();
    }
}
