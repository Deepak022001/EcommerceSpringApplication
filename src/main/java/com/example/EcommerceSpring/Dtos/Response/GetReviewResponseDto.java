package com.example.EcommerceSpring.Dtos.Response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetReviewResponseDto {

    private Long id;

    private String comment;

    private BigDecimal rating;

    private Long orderId;

    private Long productId;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
