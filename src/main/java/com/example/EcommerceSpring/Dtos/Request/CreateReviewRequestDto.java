package com.example.EcommerceSpring.Dtos.Request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateReviewRequestDto {

    private String comment;

    private BigDecimal rating;

    private Long orderId;

    private Long productId;
}
