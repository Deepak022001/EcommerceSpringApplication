package com.example.EcommerceSpring.Controller;

import com.example.EcommerceSpring.Dtos.ProductDTO;
import com.example.EcommerceSpring.Services.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class GetProductByIdController {
    private final IProductService iProductService;
    @GetMapping("/products/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable Long id) throws IOException {
        ProductDTO response= this.iProductService.getProductById(id);
        return ResponseEntity.ok(response);
    }
}
