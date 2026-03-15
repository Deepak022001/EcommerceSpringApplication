package com.example.EcommerceSpring.Repository;

import com.example.EcommerceSpring.Schema.OrderProducts;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface OrderproductsRepository extends JpaRepository<OrderProducts, Long> {

    List<OrderProducts> findByOrderId(Long orderId);
}
