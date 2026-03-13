package com.example.EcommerceSpring.Services;

import com.example.EcommerceSpring.Dtos.Request.CreateProductRequestDto;
import com.example.EcommerceSpring.Dtos.Response.GetProductResponseDto;
import com.example.EcommerceSpring.Schema.Product;
import java.io.IOException;
import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;

public interface ProductService {
    GetProductResponseDto getProductById(Long id) throws IOException;

    List<GetProductResponseDto> getAllProducts();

    GetProductResponseDto getProductWithDetailsById(Long id);

    GetProductResponseDto createProduct(@PathVariable CreateProductRequestDto requestDto);

    void deleteById(Long id);

    List<Product> getProductsByCategory(String category);

    List<String> getAllByCategory_Name();
}
