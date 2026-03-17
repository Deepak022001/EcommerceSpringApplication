package com.example.EcommerceSpring.Services;

import com.example.EcommerceSpring.Dtos.Request.CreateOrderRequestDto;
import com.example.EcommerceSpring.Dtos.Request.UpdateOrderRequestDtos;
import com.example.EcommerceSpring.Dtos.Response.GetOrderResponseDto;

import java.util.List;

public interface OrderService {
    List<GetOrderResponseDto> getAllOrders();

    GetOrderResponseDto getOrderById(Long id);

    void deleteById(Long id);

    GetOrderResponseDto createOrder(CreateOrderRequestDto createOrderRequestDto);

    List<GetOrderResponseDto> getByUserId(Long userId);

    GetOrderResponseDto updateOrder(Long id, UpdateOrderRequestDtos requestDtos);

    GetOrderResponseDto getOrderSummary(Long id);
}
