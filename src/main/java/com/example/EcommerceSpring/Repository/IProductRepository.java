package com.example.EcommerceSpring.Repository;

import com.example.EcommerceSpring.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<Product,Long> {

}
