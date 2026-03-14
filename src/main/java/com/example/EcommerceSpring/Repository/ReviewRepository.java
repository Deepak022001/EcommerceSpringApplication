package com.example.EcommerceSpring.Repository;

import com.example.EcommerceSpring.Schema.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    @Query(value = "SELECT * FROM reviews WHERE product_id = :productId", nativeQuery = true)
    List<Review> findByProductId(@Param("productId") Long productId);

    @Query(value = "SELECT * FROM reviews WHERE order_id = :orderId", nativeQuery = true)
    List<Review> findByOrderId(@Param("orderId") Long orderId);
}
