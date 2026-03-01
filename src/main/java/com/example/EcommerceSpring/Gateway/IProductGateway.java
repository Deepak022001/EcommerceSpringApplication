package com.example.EcommerceSpring.Gateway;

import com.example.EcommerceSpring.Dtos.ProductDTO;

import java.io.IOException;

public interface IProductGateway {
    ProductDTO getProductById(Long id)throws IOException;
}
