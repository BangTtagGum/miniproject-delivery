package com.example.miniprojectdelivery.service;

import com.example.miniprojectdelivery.dto.MemuResponseDto;
import com.example.miniprojectdelivery.dto.MenuRequestDto;
import com.example.miniprojectdelivery.model.Menu;
import com.example.miniprojectdelivery.model.Restaurant;
import com.example.miniprojectdelivery.repository.MenuRepository;
import com.example.miniprojectdelivery.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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

    public List<MemuResponseDto> getMenus() {
        List<Menu> menuList = menuRepository.findAll();
        return menuList.stream().map(MemuResponseDto::new).toList();
    }

    public MemuResponseDto selectMenu(Long id) {
        Menu menu = findMenu(id);
        return new MemuResponseDto(menu);
    }

    // 선택한 메뉴가 존재하는지 검사하는 메서드
    private Menu findMenu(Long id) {
        return menuRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("선택한 메뉴는 존재하지 않습니다."));
    }
}
