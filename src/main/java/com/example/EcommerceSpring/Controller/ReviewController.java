package com.example.EcommerceSpring.Controller;


import com.example.EcommerceSpring.Dtos.Request.CreateReviewRequestDto;
import com.example.EcommerceSpring.Dtos.Response.GetReviewResponseDto;
import com.example.EcommerceSpring.Services.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/reviews")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    @GetMapping
    public List<GetReviewResponseDto> getAllReviews() {
        return reviewService.getAllReviews();
    }

    @PostMapping
    public GetReviewResponseDto createReview(@RequestBody CreateReviewRequestDto createReviewRequestDto) {
        return reviewService.createReview(createReviewRequestDto);
    }

    @DeleteMapping("/{id}")
    public void deleteReview(@PathVariable Long id) {
        reviewService.deleteReview(id);
    }

    @GetMapping("/{id}")
    public GetReviewResponseDto getReviewById(@PathVariable Long id) {
        return reviewService.getReviewById(id);
    }

    @GetMapping("/product/{productId}")
    public List<GetReviewResponseDto> getReviewsByProductId(@PathVariable Long productId) {
        return reviewService.getReviewsByProductId(productId);
    }

    @GetMapping("/order/{orderId}")
    public List<GetReviewResponseDto> getReviewsByOrderId(@PathVariable Long orderId) {
        return reviewService.getReviewsByOrderId(orderId);
    }
}
