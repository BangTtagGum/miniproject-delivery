package com.example.miniprojectdelivery.controller;

import com.example.miniprojectdelivery.dto.MessageResponseDto;
import com.example.miniprojectdelivery.dto.RestaurantRequestDto;
import com.example.miniprojectdelivery.dto.RestaurantResponseDto;
import com.example.miniprojectdelivery.service.RestaurantService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RestaurantController {

    private final RestaurantService restaurantService;

    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    // 업장 생성
    @PostMapping("/restaurant")
    public RestaurantResponseDto restaurantCreate(
            @RequestBody RestaurantRequestDto restaurantRequestDto
    ) {
        return restaurantService.restaurantCreate(restaurantRequestDto);
    }

    // 업장 수정
    @PutMapping("/restaurant/{restaurantId}")
    public RestaurantResponseDto restaurantUpdate(
            @PathVariable Long restaurantId,
            @RequestBody RestaurantRequestDto restaurantRequestDto
    ) {
        return restaurantService.restaurantUpdate(restaurantId, restaurantRequestDto);
    }

    // 업장 삭제
    @DeleteMapping("/restaurant/{restaurantId}")
    public ResponseEntity<MessageResponseDto> restaurantDelete(
            @PathVariable Long restaurantId
    ) {
        return restaurantService.restaurantDelete(restaurantId);
    }

    // 업장 상세 조회
    @GetMapping("/restaurant/{restaurantId}")
    public RestaurantResponseDto getRestaurant(
            @PathVariable Long restaurantId
    ) {
        return restaurantService.getRestaurant(restaurantId);
    }

    // 키워드로 업장 검색
    @GetMapping("/restaurant/search")
    public List<RestaurantResponseDto> searchRestaurant(
            @RequestParam(value = "keyword") String keyword
    ) {
        return restaurantService.searchRestaurant(keyword);
    }


}
