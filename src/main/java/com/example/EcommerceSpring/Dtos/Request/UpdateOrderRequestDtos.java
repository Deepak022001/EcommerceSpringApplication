package com.example.EcommerceSpring.Dtos.Request;

import com.example.EcommerceSpring.Dtos.OrderItemActionDto;
import com.example.EcommerceSpring.Schema.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
//2️⃣ Get all products mentioned in the request
//List<Long> productIds = updateOrderRequestDtos.getOrderItems()
//    .stream()
//    .map(item -> item.getProductId())
//    .collect(Collectors.toList());
//
//Example request:
public class UpdateOrderRequestDtos {
    private OrderStatus status;

    private List<OrderItemActionDto> orderItems;

    //    public class OrderItemActionDto {
//        private Long productId;
//        private Integer quantity;
//        private OrderItemAction action;
//    }
//    @AllArgsConstructor
//    @NoArgsConstructor
//    public enum OrderItemAction {
//        ADD,
//        REMOVE,
//        INCREMENT,
//        DECREMENT
//    }
//
}
