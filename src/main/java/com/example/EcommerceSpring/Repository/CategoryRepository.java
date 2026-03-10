package com.example.EcommerceSpring.Repository;

import com.example.EcommerceSpring.Dtos.Request.CreateCategoryRequestDto;
import com.example.EcommerceSpring.Schema.Category;
import com.example.EcommerceSpring.Schema.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CategoryRepository extends JpaRepository<Category,Long> {
    @Query("SELECT c FROM Category c WHERE c.id=:id")
    public Category createProduct(CreateCategoryRequestDto createCategoryRequestDto) ;

    @Query("SELECT p FROM Product p WHERE p.id=:id")
    public Product getProductWithDetailsById(Long id);
}
