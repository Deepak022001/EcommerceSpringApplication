package com.example.EcommerceSpring.Services;

import com.example.EcommerceSpring.Dtos.CategoryDTO;
import com.example.EcommerceSpring.Dtos.ProductDTO;

import java.io.IOException;
import java.util.List;

public interface ICategoryService {
     List<CategoryDTO> getAllCategories() throws IOException;

}
