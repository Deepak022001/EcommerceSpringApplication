package com.example.EcommerceSpring.Dtos.Request;


import com.example.EcommerceSpring.Schema.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class  updateOrderRequestDtos {
    private OrderStatus status;
    }

