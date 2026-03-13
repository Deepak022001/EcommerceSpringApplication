package com.example.EcommerceSpring.Controller;

import com.example.EcommerceSpring.Dtos.Request.CreateProductRequestDto;
import com.example.EcommerceSpring.Dtos.Response.GetProductResponseDto;
import com.example.EcommerceSpring.Schema.Product;
import com.example.EcommerceSpring.Services.ProductService;
import java.io.IOException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/products")
public class ProductController {
    private final ProductService iProductService;

    // 1.Get All Products
    @GetMapping
    public List<GetProductResponseDto> getAllProducts() {
        return iProductService.getAllProducts();
    }

    //    1️2. Get product By id
    @GetMapping("/id/{id}")
    public GetProductResponseDto getProductById(@PathVariable Long id) throws IOException {
        return iProductService.getProductById(id);
    }

    //    2️2. Get product with details
    @GetMapping("/{id}/details")
    public GetProductResponseDto getProductWithDetailsById(@PathVariable Long id) {
        return iProductService.getProductWithDetailsById(id);
    }

    //    4 Createproduct
    @PostMapping
    public GetProductResponseDto createProduct(@RequestBody CreateProductRequestDto requestDto) {
        return iProductService.createProduct(requestDto);
    }

    //    5.Delete Product
    @DeleteMapping("/id/{id}")
    public void deletById(@PathVariable Long id) {
        iProductService.deleteById(id);
    }

    //    6.Search Product By Category
    @GetMapping("/search")
    public List<Product> getProductsByCategory(@RequestParam("categoryName") String category) {
        return iProductService.getProductsByCategory(category);
    }

    // 7️7. Get all categories
    @GetMapping("/categories")
    private List<String> getAllByCategory() {
        return iProductService.getAllByCategory_Name();
    }
}
