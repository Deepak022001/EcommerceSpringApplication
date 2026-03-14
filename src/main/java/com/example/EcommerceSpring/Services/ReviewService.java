package com.example.EcommerceSpring.Services;


import com.example.EcommerceSpring.Dtos.Request.CreateReviewRequestDto;
import com.example.EcommerceSpring.Dtos.Response.GetReviewResponseDto;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface ReviewService {
    GetReviewResponseDto createReview(CreateReviewRequestDto createReviewRequestDto);

    GetReviewResponseDto getReviewById(Long id);

    void deleteReview(Long id);

    List<GetReviewResponseDto> getAllReviews();

    List<GetReviewResponseDto> getReviewsByProductId(Long productId);

    List<GetReviewResponseDto> getReviewsByOrderId(@PathVariable Long id);
}
