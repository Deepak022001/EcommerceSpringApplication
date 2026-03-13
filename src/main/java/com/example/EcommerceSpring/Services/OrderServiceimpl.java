package com.example.EcommerceSpring.Services;

import com.example.EcommerceSpring.Dtos.Request.CreateOrderRequestDto;
import com.example.EcommerceSpring.Dtos.Request.updateOrderRequestDtos;
import com.example.EcommerceSpring.Dtos.Response.GetOrderResponseDto;
import com.example.EcommerceSpring.Repository.OrderRepository;
import com.example.EcommerceSpring.Schema.Order;
import com.example.EcommerceSpring.Schema.OrderStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceimpl implements OrderService {

    private final OrderRepository orderRepository;

    @Override
    public List<GetOrderResponseDto> getAllOrders() {
        List<Order> orders = orderRepository.findAll();
        return orders.stream()
            .map(order -> GetOrderResponseDto.builder()
                .id(order.getId())
                .status(order.getStatus())
                .createdAt(order.getCreatedAt())
                .updatedAt(order.getUpdatedAt())
                .build())
            .toList();
    }

    @Override
    public GetOrderResponseDto getOrderById(Long id) {
        Order newOrder = orderRepository
            .findById(id)
            .orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "Order not found"));
        return GetOrderResponseDto.builder()
            .id(newOrder.getId())
            .status(newOrder.getStatus())
            .items(List.of())
            .createdAt(newOrder.getCreatedAt())
            .updatedAt(newOrder.getUpdatedAt())
            .build();
    }


    @Override
    public GetOrderResponseDto createOrder(CreateOrderRequestDto createOrderRequestDto) {
        Order newOrder = Order.builder()
            .status(OrderStatus.PENDING)
            .build();
        orderRepository.save(newOrder);
        return GetOrderResponseDto.builder()
            .id(newOrder.getId())
            .status(newOrder.getStatus())
            .items(List.of())
            .createdAt(newOrder.getCreatedAt())
            .updatedAt(newOrder.getUpdatedAt())
            .build();

    }

    @Override
    public void deleteById(Long id) {
        orderRepository.deleteById(id);
    }

    @Override
    public List<GetOrderResponseDto> getByUserId(Long userId) {
        List<Order> orders = orderRepository.findOrdersByUserId(userId);
        return orders.stream()
            .map(order -> GetOrderResponseDto.builder()
                .id(order.getId())
                .status(order.getStatus())
                .items(List.of())
                .createdAt(order.getCreatedAt())
                .updatedAt(order.getUpdatedAt())
                .build())
            .toList();
    }

    @Override
    public GetOrderResponseDto updateOrder(Long id, updateOrderRequestDtos requestDtos) {
        Order exisitingOrder =
            orderRepository
                .findById(id)
                .orElseThrow(
                    () ->
                        new ResponseStatusException(
                            HttpStatus.NOT_FOUND,
                            "Order not found"));
        exisitingOrder.setStatus(requestDtos.getStatus());
        orderRepository.save(exisitingOrder);
        return GetOrderResponseDto.builder()
            .id(exisitingOrder.getId())
            .status(exisitingOrder.getStatus())
            .items(List.of())
            .createdAt(exisitingOrder.getCreatedAt())
            .updatedAt(exisitingOrder.getUpdatedAt())
            .build();
    }

    @Override
    public GetOrderResponseDto getOrderSummary(Long id) {
        Order order =
            orderRepository
                .findById(id)
                .orElseThrow(
                    () ->
                        new ResponseStatusException(
                            HttpStatus.NOT_FOUND,
                            "Order not found"));
        return GetOrderResponseDto.builder()
            .id(order.getId())
            .status(order.getStatus())
            .createdAt(order.getCreatedAt())
            .updatedAt(order.getUpdatedAt())
            .build();
    }
}
