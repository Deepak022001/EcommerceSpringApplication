package com.example.EcommerceSpring.Services;

import java.util.List;

import com.example.EcommerceSpring.Dtos.Request.updateOrderRequestDtos;
import com.example.EcommerceSpring.Dtos.Response.GetOrderResponseDto;
import com.example.EcommerceSpring.Schema.Order;
import com.example.EcommerceSpring.Services.OrderService;
import org.springframework.web.bind.annotation.*;


import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
//        throw new UnsupportedOperationException("Not implemented");
    }

    @PostMapping
    public Order createOrder(@RequestBody GetOrderResponseDto responseDto) {
        return orderService.createOrder(responseDto);
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id) {
        orderService.deleteById(id);
    }

    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }

    @GetMapping("/user/{userId}")
    public List<Order> getOrdersByUserId(@PathVariable Long userId) {
        return orderService.getByUserId(userId);
    }

    @PutMapping("/{id}")
    public Order updateOrder(@PathVariable Long id,@RequestBody updateOrderRequestDtos requestDtos) {
        return orderService.updateOrder(id,requestDtos);
    }


    @GetMapping("/{id}/summary")
    public GetOrderResponseDto getOrderSummary(@PathVariable Long id) {
        return orderService.getOrderSummary(id);
    }

}
