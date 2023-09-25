package com.example.miniprojectdelivery.controller;

import com.example.miniprojectdelivery.dto.MessageResponseDto;
import com.example.miniprojectdelivery.dto.restaurant.RestaurantRequestDto;
import com.example.miniprojectdelivery.dto.restaurant.RestaurantResponseDto;
import com.example.miniprojectdelivery.service.RestaurantService;
import com.example.miniprojectdelivery.utill.security.UserDetailsImpl;
import jakarta.validation.Valid;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/restaurants")
public class RestaurantController {

    private final RestaurantService restaurantService;

    /**
     * 음식점 생성 메소드 - 사장님당 1개씩만 생성 가능
     * @param userDetails 음식점 생성하려는 사장님 정보
     * @param restaurantRequestDto 생성하려는 음식점 정보
     * @return
     */

    @ResponseBody
    @Secured("ROLE_OWNER")
    @PostMapping
    public RestaurantResponseDto restaurantCreate(
            @AuthenticationPrincipal UserDetailsImpl userDetails,
            @Valid @RequestBody RestaurantRequestDto restaurantRequestDto

    ) {
        return restaurantService.restaurantCreate(userDetails.getUser(),restaurantRequestDto);
    }

    /**
     * 음식점 정보 수정 메소드
     * @param restaurantId 수정할 음식점 메소드
     * @param restaurantRequestDto 수정할 음식점 정보
     */
    @Secured("ROLE_OWNER")
    @PutMapping("/{restaurantId}")
    public RestaurantResponseDto restaurantUpdate(
            @PathVariable Long restaurantId,
            @Valid @RequestBody RestaurantRequestDto restaurantRequestDto
    ) {
        return restaurantService.restaurantUpdate(restaurantId, restaurantRequestDto);
    }

    /**
     * 음식점 삭제 메소드
     * @param restaurantId 삭제할 음식점 id
     */
    @Secured("ROLE_OWNER")
    @DeleteMapping("/{restaurantId}")
    public ResponseEntity<MessageResponseDto> restaurantDelete(
            @PathVariable Long restaurantId
    ) {
        Map<String, Long> object = new HashMap<>();
        return restaurantService.restaurantDelete(restaurantId);
    }

    // 업장 상세 조회
    @GetMapping("/{restaurantId}")
    public String getRestaurant(
            @PathVariable Long restaurantId,
            Model model
    ) {
        model.addAttribute("Menus", restaurantService.getRestaurant(restaurantId));
        return "store";
    }

//    @GetMapping("/detail/{id}")
//    public String detailRestaurant(Model model, @PathVariable Long id){
//        model.addAttribute("restid", id);
//        return "store";
//    }

    // 키워드로 업장 검색
    @ResponseBody
    @GetMapping("/search")
    //public ResponseEntity<List<RestaurantResponseDto>> searchRestaurant(
    public List<RestaurantResponseDto> searchRestaurant(
    @RequestParam(value = "query") String query
    ) {
        return restaurantService.searchRestaurant(query);
        //return ResponseEntity.ok().body(restaurantService.searchRestaurant(query));
    }

}
