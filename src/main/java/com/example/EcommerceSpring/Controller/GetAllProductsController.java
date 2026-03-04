package com.example.EcommerceSpring.Controller;

import com.example.EcommerceSpring.Dtos.CategoryDTO;
import com.example.EcommerceSpring.Services.ICategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1")
public class GetAllProductsController {
//    private CategoryService categoryService
//    depending on concrete class is violating Dependecy inversion

    private final ICategoryService iCategoryService;
    @GetMapping("/products")
    public ResponseEntity< List<CategoryDTO>> getAllCategories() throws IOException {
        List<CategoryDTO>response=this.iCategoryService.getAllCategories();
        return ResponseEntity.ok(response);
    }
}
