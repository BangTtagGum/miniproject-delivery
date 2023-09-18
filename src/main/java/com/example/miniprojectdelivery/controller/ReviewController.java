package com.example.miniprojectdelivery.controller;

import com.example.miniprojectdelivery.dto.BaseResponse;
import com.example.miniprojectdelivery.dto.ReviewRequestDto;
import com.example.miniprojectdelivery.dto.ReviewResponseDto;
import com.example.miniprojectdelivery.service.ReviewService;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/restaurants/")
public class ReviewController {

    private final ReviewService reviewService;

    @PostMapping("/{restaurantId}/reviews")
    public ReviewResponseDto createReview(@PathVariable Long restaurantId,
            @RequestBody @Valid ReviewRequestDto requestDto) {
        ReviewResponseDto responseDto = reviewService.createReview(restaurantId, requestDto);
        return responseDto;
    }

    @PutMapping("/reviews/{id}")
    public ReviewResponseDto updateReview(@PathVariable Long id,
            @RequestBody @Valid ReviewRequestDto requestDto) {
        ReviewResponseDto responseDto = reviewService.updateReview(id, requestDto);
        return responseDto;
    }

    @DeleteMapping("/reviews/{id}")
    public BaseResponse deleteReview(@PathVariable Long id) {
        String message = reviewService.deleteReview(id);
        return new BaseResponse(HttpStatus.OK, message);
    }

}
