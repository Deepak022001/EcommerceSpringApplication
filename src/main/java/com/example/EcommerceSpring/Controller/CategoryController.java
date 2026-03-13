package com.example.EcommerceSpring.Controller;

import com.example.EcommerceSpring.Dtos.Request.CreateCategoryRequestDto;
import com.example.EcommerceSpring.Schema.Category;
import com.example.EcommerceSpring.Services.CategoryService;
import java.io.IOException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/categories")
public class CategoryController {

    private final CategoryService iCategoryService;

    @PostMapping
    public Category CreateNewCategory(
            @RequestBody CreateCategoryRequestDto createCategoryRequestDto) {
        return iCategoryService.createCategory(createCategoryRequestDto);
    }

    @GetMapping
    public List<Category> getAllCategories() throws IOException {
        return iCategoryService.getAllCategories();
    }

    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable Long id) {
        return iCategoryService.getCategoryById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteCategoryById(@PathVariable Long id) {
        iCategoryService.deleteCategoryById(id);
    }
}
