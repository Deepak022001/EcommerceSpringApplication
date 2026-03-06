package com.example.EcommerceSpring.Services;

import com.example.EcommerceSpring.Dtos.ProductDTO;
import com.example.EcommerceSpring.Entity.Product;

import java.io.IOException;

public interface IProductService {
    ProductDTO getProductById(Long id) throws IOException;
    ProductDTO createProduct(ProductDTO productDTO);
}
