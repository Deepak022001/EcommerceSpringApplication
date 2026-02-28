package com.example.EcommerceSpring.Gateway;

import com.example.EcommerceSpring.Dtos.CategoryDTO;

import java.io.IOException;
import java.util.List;

public interface ICategoryGateway {
    List<CategoryDTO> getAllCategories() throws IOException;
}
