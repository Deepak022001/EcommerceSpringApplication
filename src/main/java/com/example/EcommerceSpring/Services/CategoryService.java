package com.example.EcommerceSpring.Services;

import com.example.EcommerceSpring.Dtos.Request.CreateCategoryRequestDto;
import com.example.EcommerceSpring.Schema.Category;
import java.io.IOException;
import java.util.List;

public interface CategoryService {
    List<Category> getAllCategories() throws IOException;

    Category createCategory(CreateCategoryRequestDto createCategoryRequestDto);

    Category getCategoryById(Long id);

    void deleteCategoryById(Long id);
}
