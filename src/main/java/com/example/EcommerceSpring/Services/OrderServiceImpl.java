package com.example.EcommerceSpring.Services;

import com.example.EcommerceSpring.Dtos.OrderItemActionDto;
import com.example.EcommerceSpring.Dtos.Request.CreateOrderRequestDto;
import com.example.EcommerceSpring.Dtos.Request.UpdateOrderRequestDtos;
import com.example.EcommerceSpring.Dtos.Response.GetOrderResponseDto;
import com.example.EcommerceSpring.Repository.OrderRepository;
import com.example.EcommerceSpring.Repository.OrderproductsRepository;
import com.example.EcommerceSpring.Repository.ProductRepository;
import com.example.EcommerceSpring.Schema.Order;
import com.example.EcommerceSpring.Schema.OrderProducts;
import com.example.EcommerceSpring.Schema.OrderStatus;
import com.example.EcommerceSpring.Schema.Product;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final OrderproductsRepository orderproductsRepository;

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

        Order order = orderRepository
            .findById(id)
            .orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "Order not found"));

        return GetOrderResponseDto.builder()
            .id(order.getId())
            .status(order.getStatus())
            .items(List.of())
            .createdAt(order.getCreatedAt())
            .updatedAt(order.getUpdatedAt())
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

    @Transactional
    @Override
    public GetOrderResponseDto createOrder(CreateOrderRequestDto createOrderRequestDto) {

        Order order = Order.builder()
            .status(OrderStatus.PENDING)
            .build();

        orderRepository.save(order);

        if (createOrderRequestDto.getItems() != null) {

            List<Long> productIds =
                createOrderRequestDto.getItems()
                    .stream()
                    .map(item -> item.getProductId())
                    .collect(Collectors.toList());

            List<Product> products = productRepository.findAllById(productIds);

            Map<Long, Product> productMap =
                products.stream()
                    .collect(Collectors.toMap(Product::getId,
                        Function.identity()));

            for (Long id : productIds) {
                if (!productMap.containsKey(id)) {
                    throw new RuntimeException("Product not found with id: " + id);
                }
            }

            List<OrderProducts> orderProducts = new ArrayList<>();

            for (var itemDto : createOrderRequestDto.getItems()) {

                Product product = productMap.get(itemDto.getProductId());

                orderProducts.add(
                    OrderProducts.builder()
                        .order(order)
                        .product(product)
                        .quantity(itemDto.getQuantity() != null ? itemDto.getQuantity() : 1)
                        .build());
            }

            orderproductsRepository.saveAll(orderProducts);
        }

        return GetOrderResponseDto.builder()
            .id(order.getId())
            .status(order.getStatus())
            .items(List.of())
            .createdAt(order.getCreatedAt())
            .updatedAt(order.getUpdatedAt())
            .build();
    }

    @Override
    public GetOrderResponseDto updateOrder(Long id, UpdateOrderRequestDtos updateOrderRequestDtos) {
        {

            // Step 1: Fetch order
            Order order = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order Not Found")); // ✅ fixed message

            // Step 2: Fetch products from request
            List<Long> productIds = updateOrderRequestDtos.getOrderItems()
                .stream()
                .map(p -> p.getProductId())
                .toList();
            List<Product> products = productRepository.findAllById(productIds);

            Map<Long, Product> productRequestMap = products.stream()
                .collect(Collectors.toMap(Product::getId,
                    p -> p));

            // Step 3: Fetch existing order items
            Map<Long, OrderProducts> existingitemMap = orderproductsRepository
                .findByOrderWithProduct(order)
                .stream()
                .collect(Collectors.toMap(
                    op -> op.getProduct()
                        .getId(),
                    op -> op
                ));

            List<OrderProducts> toSave = new ArrayList<>();
            List<OrderProducts> toDelete = new ArrayList<>();

            // Step 4: Process actions
            for (OrderItemActionDto orderItemActionDto : updateOrderRequestDtos.getOrderItems()) {

                Product product = productRequestMap.get(orderItemActionDto.getProductId());
                OrderProducts existing = existingitemMap.get(product.getId());

                switch (orderItemActionDto.getAction()) {

                    case ADD -> {
                        if (existing != null) {
                            int addQty = (orderItemActionDto.getQuantity() != null)
                                ? orderItemActionDto.getQuantity()
                                : 1;

                            existing.setQuantity(existing.getQuantity() + addQty);
                            toSave.add(existing);

                        } else {

                            int qty = (orderItemActionDto.getQuantity() != null)
                                ? orderItemActionDto.getQuantity()
                                : 1;

                            OrderProducts newItem = OrderProducts.builder()
                                .order(order)
                                .product(product)
                                .quantity(qty)
                                .build();

                            existingitemMap.put(product.getId(),
                                newItem);

                            toSave.add(newItem);
                        }
                    }

                    case REMOVE -> {
                        if (existing == null) {
                            throw new RuntimeException("Product not found in order: " + product.getId());
                        }

                        toDelete.add(existing);
                        existingitemMap.remove(product.getId());
                    }

                    case INCREMENT -> {
                        if (existing == null) {
                            throw new RuntimeException("Product not found in order: " + product.getId());
                        }

                        existing.setQuantity(existing.getQuantity() + 1);
                        toSave.add(existing);
                    }

                    case DECREMENT -> {
                        if (existing == null) {
                            throw new RuntimeException("Product not found in order: " + product.getId());
                        }

                        if (existing.getQuantity() <= 1) {
                            toDelete.add(existing);
                            existingitemMap.remove(product.getId());
                        } else {
                            existing.setQuantity(existing.getQuantity() - 1);
                            toSave.add(existing);
                        }
                    }
                }
            }
            if (!toSave.isEmpty()) {
                orderproductsRepository.saveAll(toSave);
            }

            if (!toDelete.isEmpty()) {
                orderproductsRepository.deleteAll(toDelete);
            }
            return GetOrderResponseDto.builder()
                .id(order.getId())
                .status(order.getStatus())
                .items(List.of())
                .createdAt(order.getCreatedAt())
                .updatedAt(order.getUpdatedAt())
                .build();
        }
    }

    @Override
    public GetOrderResponseDto getOrderSummary(Long id) {
        Order order =
            orderRepository
                .findById(id)
                .orElseThrow(() ->
                    new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Order not found"));

        return GetOrderResponseDto.builder()
            .id(order.getId())
            .status(order.getStatus())
            .createdAt(order.getCreatedAt())
            .updatedAt(order.getUpdatedAt())
            .build();
    }
}
