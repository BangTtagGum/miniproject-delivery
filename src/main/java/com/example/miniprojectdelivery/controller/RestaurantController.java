package com.example.miniprojectdelivery.controller;

import com.example.miniprojectdelivery.dto.MessageResponseDto;
import com.example.miniprojectdelivery.dto.RestaurantRequestDto;
import com.example.miniprojectdelivery.dto.RestaurantResponseDto;
import com.example.miniprojectdelivery.service.RestaurantService;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/restaurants")
public class RestaurantController {

    private final RestaurantService restaurantService;

    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    // 업장 생성
    @PostMapping
    public RestaurantResponseDto restaurantCreate(
            @RequestBody RestaurantRequestDto restaurantRequestDto
    ) {
        return restaurantService.restaurantCreate(restaurantRequestDto);
    }

    // 업장 수정
    @PutMapping("/{restaurantId}")
    public RestaurantResponseDto restaurantUpdate(
            @PathVariable Long restaurantId,
            @RequestBody RestaurantRequestDto restaurantRequestDto
    ) {
        return restaurantService.restaurantUpdate(restaurantId, restaurantRequestDto);
    }

    // 업장 삭제
    @DeleteMapping("/{restaurantId}")
    public ResponseEntity<MessageResponseDto> restaurantDelete(
            @PathVariable Long restaurantId
    ) {
        return restaurantService.restaurantDelete(restaurantId);
    }

    // 업장 상세 조회
    @GetMapping("/{restaurantId}")
    public RestaurantResponseDto getRestaurant(
            @PathVariable Long restaurantId
    ) {
        return restaurantService.getRestaurant(restaurantId);
    }

    // 키워드로 업장 검색
    @GetMapping("/search")
    public List<RestaurantResponseDto> searchRestaurant(
            @RequestParam(value = "keyword") String keyword
    ) {
        return restaurantService.searchRestaurant(keyword);
    }


}
