package com.example.EcommerceSpring.Repository;

import com.example.EcommerceSpring.Schema.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface OrderRepository extends JpaRepository<Order, Long> {

    // Placeholder until a real user relation exists on Order.
    @Query("SELECT o FROM Order o WHERE o.id = :userId")
    List<Order> findOrdersByUserId(Long userId);
}
