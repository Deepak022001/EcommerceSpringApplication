package com.example.EcommerceSpring.Services;


import com.example.EcommerceSpring.Dtos.Request.CreateCategoryRequestDto;
import com.example.EcommerceSpring.Schema.Category;

import java.io.IOException;
import java.util.List;

public interface CategoryService {
     List<CreateCategoryRequestDto> getAllCategories() throws IOException;
     Category getCategoryById(Long id);
     Category createProduct(CreateCategoryRequestDto createCategoryRequestDto);
}
