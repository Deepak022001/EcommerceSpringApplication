package com.example.EcommerceSpring.Dtos.Response;

import java.time.LocalDateTime;
import java.util.List;

import com.example.EcommerceSpring.Schema.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.example.EcommerceSpring.Dtos.Response.OrderItemResponseDto;

@Data 
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetOrderResponseDto {
    

    private Long id;

    private OrderStatus status;

    private List<OrderItemResponseDto> items;
    

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
