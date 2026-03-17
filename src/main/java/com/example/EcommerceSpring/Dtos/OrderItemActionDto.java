package com.example.EcommerceSpring.Dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class OrderItemActionDto {
    private Long productId;
    private Integer quantity;
    private OrderItemAction action;
}
