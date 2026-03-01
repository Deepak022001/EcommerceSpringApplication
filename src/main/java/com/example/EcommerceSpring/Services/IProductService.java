package com.example.EcommerceSpring.Services;

import com.example.EcommerceSpring.Dtos.ProductDTO;

import java.io.IOException;

public interface IProductService {
    ProductDTO getProductById(Long id) throws IOException;
}
