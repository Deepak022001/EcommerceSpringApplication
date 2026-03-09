package com.example.EcommerceSpring.Repository;
import com.example.EcommerceSpring.Schema.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface IProductRepository extends JpaRepository<Product,Long> {

    @Query(nativeQuery = true, value = "SELECT DISTINCT category FROM products")
    List<Product>findByCategory_Name(String name);

    @Query("SELECT p FROM Product p WHERE p.id=:id")
    Product getProductWithDetailsById(Long id);

    @Query("SELECT DISTINCT p.category.name FROM Product p")
    List<String> findAllCategories();



}

