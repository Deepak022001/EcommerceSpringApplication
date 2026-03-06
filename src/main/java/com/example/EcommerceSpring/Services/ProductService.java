package com.example.EcommerceSpring.Services;

import com.example.EcommerceSpring.Dtos.ProductDTO;
import com.example.EcommerceSpring.Entity.Product;
import com.example.EcommerceSpring.Repository.IProductRepository;
import com.example.EcommerceSpring.mapppers.ProductMappers;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service("ProductService")
@RequiredArgsConstructor
public class ProductService implements IProductService{
private final IProductRepository iProductRepository;
    @Override
    public ProductDTO getProductById(Long id) throws IOException {
        Product product= iProductRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Product Not Found"));
        return ProductMappers.toDto(product);
    }

    @Override
    public ProductDTO createProduct(ProductDTO productDTO) {
        Product product= iProductRepository.save(ProductMappers.toEntity(productDTO));
        return ProductMappers.toDto(product);
    }
}
