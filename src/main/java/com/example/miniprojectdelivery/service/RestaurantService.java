package com.example.miniprojectdelivery.service;

import com.example.miniprojectdelivery.dto.MessageResponseDto;
import com.example.miniprojectdelivery.dto.RestaurantRequestDto;
import com.example.miniprojectdelivery.dto.RestaurantResponseDto;
import com.example.miniprojectdelivery.model.Restaurant;
import com.example.miniprojectdelivery.repository.RestaurantRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;

    public RestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }


    // 업장 생성
    @Transactional
    public RestaurantResponseDto restaurantCreate(RestaurantRequestDto restaurantRequestDto) {
        Restaurant restaurant = new Restaurant(restaurantRequestDto);
        Restaurant saveRestaurant = restaurantRepository.save(restaurant);
        return new RestaurantResponseDto(saveRestaurant);


    }

    // 업장 수정
    @Transactional
    public RestaurantResponseDto restaurantUpdate(Long id, RestaurantRequestDto restaurantRequestDto) {
        Restaurant restaurant = findRestaurant(id);
        restaurant.update(restaurantRequestDto);
        return new RestaurantResponseDto(restaurant);
    }

    // 업장 삭제
    @Transactional
    public ResponseEntity<MessageResponseDto> restaurantDelete(Long id) {
        Restaurant restaurant = findRestaurant(id);
        restaurantRepository.delete(restaurant);
        MessageResponseDto msg = new MessageResponseDto("업장 정보가 삭제되었습니다.");
        return ResponseEntity.status(200).body(msg);
    }

    // 업장 조회
    private Restaurant findRestaurant(Long id) {
        return restaurantRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("선택한 업장이 없습니다."));
    }

    // 업장 상세 조회
    public RestaurantResponseDto getRestaurant(Long id) {
        Restaurant restaurant = findRestaurant(id);
        return new RestaurantResponseDto(restaurant);
    }

    // 업장 키워드 검색
    @Transactional
    public List<RestaurantResponseDto> searchRestaurant(String keyword) {
        return restaurantRepository.findByNameContaining(keyword).stream().map(RestaurantResponseDto::new).toList();
    }
}
