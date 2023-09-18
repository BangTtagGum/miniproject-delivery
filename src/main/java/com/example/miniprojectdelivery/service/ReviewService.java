package com.example.miniprojectdelivery.service;

import com.example.miniprojectdelivery.dto.ReviewRequestDto;
import com.example.miniprojectdelivery.dto.ReviewResponseDto;
import com.example.miniprojectdelivery.model.Review;
import com.example.miniprojectdelivery.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final RestaurantRepository restaurantRepository;
    private final UserRepository userRepository;

    public ReviewResponseDto createReview(Long restaurantId, ReviewRequestDto requestDto) {
        Restaurant restaurant = restaurantRepository.findById(restaurantId).orElseThrow(
                () -> {
                    throw new IllegalArgumentException("해당 ID의 음식점이 존재하지 않습니다.");
                }
        );
        User user = userRepository.findById(1L).orElseThrow(
                () -> {
                    throw new IllegalArgumentException("해당 ID의 유저가 존재하지 않습니다.");
                }
        );

        Review review = new Review();
        review.addContentAndStars(requestDto);
        review.addRestaurant(restaurant);
        review.addUser(user);

        reviewRepository.save(review);

        ReviewResponseDto responseDto = new ReviewResponseDto(review);
        return responseDto;
    }

    @Transactional
    public ReviewResponseDto updateReview(Long reviewId, ReviewRequestDto requestDto) {
        Review review = findReview(reviewId);
        review.updateContentAndStars(requestDto);

        ReviewResponseDto responseDto = new ReviewResponseDto(review);
        return responseDto;
    }

    // todo: 임시로 String으로 반환 이후 페이지로 반환할 거 고민해 봐야 함
    public String  deleteReview(Long id) { // 임시로 String 으로 반환
        Review review = findReview(id);
        reviewRepository.delete(review);
        return "리뷰 삭제에 성공 했습니다.";

    }

    private Review findReview(Long id) {
        return reviewRepository.findById(id).orElseThrow(() -> {
            throw new IllegalArgumentException("해당 id의 리뷰가 존재하지 않습니다. Review ID: " + id);
        });
    }
}
