package com.example.miniprojectdelivery.controller;

import com.example.miniprojectdelivery.dto.BaseResponse;
import com.example.miniprojectdelivery.dto.ReviewCreateRequestDto;
import com.example.miniprojectdelivery.dto.ReviewResponseDto;
import com.example.miniprojectdelivery.dto.ReviewUpdateRequestDto;
import com.example.miniprojectdelivery.service.ReviewService;
import com.example.miniprojectdelivery.utill.security.UserDetailsImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/reviews")
public class ReviewController {

    private final ReviewService reviewService;

    @PostMapping
    public ReviewResponseDto createReview(@AuthenticationPrincipal UserDetailsImpl userDetails,
            @RequestBody @Valid ReviewCreateRequestDto requestDto) {
        ReviewResponseDto responseDto = reviewService.createReview(userDetails.getUser(), requestDto);
        return responseDto;
    }

    @PutMapping("/{id}")
    public ReviewResponseDto updateReview(@PathVariable Long id,
            @RequestBody @Valid ReviewUpdateRequestDto requestDto) {
        ReviewResponseDto responseDto = reviewService.updateReview(id, requestDto);
        return responseDto;
    }

    @DeleteMapping("/{id}")
    public BaseResponse deleteReview(@PathVariable Long id) {
        String message = reviewService.deleteReview(id);
        return new BaseResponse(HttpStatus.OK, message);
    }

}
