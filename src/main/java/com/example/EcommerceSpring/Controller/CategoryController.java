package com.example.EcommerceSpring.Controller;
import com.example.EcommerceSpring.Dtos.Request.CreateCategoryRequestDto;
import com.example.EcommerceSpring.Schema.Category;
import com.example.EcommerceSpring.Services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/categories")
public class CategoryController {

private final CategoryService iCategoryService;

// POST /api/v1/categories
@PostMapping 
public  Category CreateNewCategory(@RequestBody CreateCategoryRequestDto createCategoryRequestDto){
    return iCategoryService.createCategory(createCategoryRequestDto);
}
//Get All Categories
    @GetMapping
    public List<Category> getAllCategories() throws IOException {
    return iCategoryService.getAllCategories();
    }
//    Get Category By Id
    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable Long id){
    return iCategoryService.getCategoryById(id);
    }
    @DeleteMapping("/{id}")
    public void deleteCategoryById(@PathVariable Long id){
        iCategoryService.deleteCategoryById(id);
    }
}
