package com.example.EcommerceSpring.Services;

import com.example.EcommerceSpring.Dtos.Request.updateOrderRequestDtos;
import com.example.EcommerceSpring.Dtos.Response.GetOrderResponseDto;
import com.example.EcommerceSpring.Schema.Order;
import org.aspectj.weaver.ast.Or;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface OrderService {
      List<Order> getAllOrders();
      Order getOrderById(Long id);
      void deleteById(Long id);
      Order createOrder(GetOrderResponseDto responseDto);
      List<Order>getByUserId(Long userId);
      Order updateOrder(Long id, updateOrderRequestDtos requestDtos);
      GetOrderResponseDto getOrderSummary(Long id);
}
