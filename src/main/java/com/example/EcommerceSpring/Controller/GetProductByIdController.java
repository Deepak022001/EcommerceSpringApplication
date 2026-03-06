package com.example.EcommerceSpring.Controller;

import com.example.EcommerceSpring.Dtos.ProductDTO;
import com.example.EcommerceSpring.Entity.Product;
import com.example.EcommerceSpring.Services.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController

@RequestMapping("/api/v1")
public class GetProductByIdController {
    private final IProductService iProductService;
    private GetProductByIdController(@Qualifier("ProductService") IProductService iProductService){
        this.iProductService=iProductService;
    }
    @GetMapping("/products/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable Long id) throws IOException {
        ProductDTO response= this.iProductService.getProductById(id);
        return ResponseEntity.ok(response);
    }
    public ResponseEntity<ProductDTO>createProduct(@RequestBody ProductDTO dto){
        return ResponseEntity.ok(iProductService.createProduct(dto));
    }
}
