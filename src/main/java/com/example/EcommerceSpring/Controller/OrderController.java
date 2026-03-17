package com.example.EcommerceSpring.Controller;

import com.example.EcommerceSpring.Dtos.Request.CreateOrderRequestDto;
import com.example.EcommerceSpring.Dtos.Request.UpdateOrderRequestDtos;
import com.example.EcommerceSpring.Dtos.Response.GetOrderResponseDto;
import com.example.EcommerceSpring.Services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @GetMapping
    public List<GetOrderResponseDto> getAllOrders() {
        return orderService.getAllOrders();
    }

    @PostMapping
    public GetOrderResponseDto createOrder(@RequestBody CreateOrderRequestDto createOrderRequestDto) {
        return orderService.createOrder(createOrderRequestDto);
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id) {
        orderService.deleteById(id);
    }

    @GetMapping("/{id}")
    public GetOrderResponseDto getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }

    @GetMapping("/user/{userId}")
    public List<GetOrderResponseDto> getOrdersByUserId(@PathVariable Long userId) {
        return orderService.getByUserId(userId);
    }

    @PutMapping("/{id}")
    public GetOrderResponseDto updateOrder(
        @PathVariable Long id, @RequestBody UpdateOrderRequestDtos requestDtos) {
        return orderService.updateOrder(id,
            requestDtos);
    }

    @GetMapping("/{id}/summary")
    public GetOrderResponseDto getOrderSummary(@PathVariable Long id) {
        return orderService.getOrderSummary(id);
    }
}
