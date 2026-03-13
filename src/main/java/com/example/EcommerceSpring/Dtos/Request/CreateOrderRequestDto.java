package com.example.EcommerceSpring.Dtos.Request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateOrderRequestDto {
    private Long userId;
    private List<CreateOrderItemRequestDto> items;
    private String shippingAddress;
}
