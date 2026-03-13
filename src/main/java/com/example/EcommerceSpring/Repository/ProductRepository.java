package com.example.EcommerceSpring.Repository;

import com.example.EcommerceSpring.Schema.Product;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

@Component
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByCategory_Name(String name);

    @Query("SELECT p FROM Product p WHERE p.id=:id")
    Product getProductWithDetailsById(Long id);

    @Query("SELECT DISTINCT p.category.name FROM Product p")
    List<String> findAllCategories();

    boolean existsByCategory_Id(Long id);
}
