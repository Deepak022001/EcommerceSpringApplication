package com.example.EcommerceSpring.Controller;

import com.example.EcommerceSpring.Dtos.CategoryDTO;
import com.example.EcommerceSpring.Services.ICategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController

@RequestMapping("api/v1")
public class CategoryController {
//    private CategoryService categoryService
//    depending on concrete class is violating Dependecy inversion

    private  ICategoryService iCategoryService;
    CategoryController(ICategoryService _iCategoryService){
                this.iCategoryService=_iCategoryService;
    }
    @GetMapping("/categories")
    public List<CategoryDTO> getAllCategories() throws IOException {
        return this.iCategoryService.getAllCategories();
    }

}
