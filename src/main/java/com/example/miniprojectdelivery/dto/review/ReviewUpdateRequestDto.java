package com.example.miniprojectdelivery.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class ReviewUpdateRequestDto {

    @NotBlank(message = "리뷰 내용을 입력해 주세요!")
    private String content; // 리뷰 내용

    @NotNull(message = "평점을 남겨주세요!")
    @Size(min = 0, max = 10, message = "평점은 별 5개(10점)까지 가능합니다!")
    private Integer star; // 리뷰 평점
}
