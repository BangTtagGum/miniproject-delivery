package com.example.miniprojectdelivery.service;

import com.example.miniprojectdelivery.dto.MemuResponseDto;
import com.example.miniprojectdelivery.dto.MenuRequestDto;
import com.example.miniprojectdelivery.dto.MessageResponseDto;
import com.example.miniprojectdelivery.model.Menu;
import com.example.miniprojectdelivery.model.Restaurant;
import com.example.miniprojectdelivery.repository.MenuRepository;
import com.example.miniprojectdelivery.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MenuService {

    private final MenuRepository menuRepository;
    private final RestaurantRepository restaurantRepository;
    public MemuResponseDto createMenu(MenuRequestDto requestDto) {
        Restaurant restaurant = restaurantRepository.findById(requestDto.getRestaurantId()).orElseThrow(
                ()-> new IllegalArgumentException("음식점을 찾을 수 없습니다"));
        Menu menu = menuRepository.save(new Menu(requestDto, restaurant));
       return new MemuResponseDto(menu);
    }
}
