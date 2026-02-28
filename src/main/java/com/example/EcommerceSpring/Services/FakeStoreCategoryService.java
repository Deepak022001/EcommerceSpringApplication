package com.example.EcommerceSpring.Services;

import com.example.EcommerceSpring.Dtos.CategoryDTO;
import com.example.EcommerceSpring.Gateway.ICategoryGateway;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class FakeStoreCategoryService implements ICategoryService {
private final ICategoryGateway iCategoryGateway;
    public FakeStoreCategoryService(ICategoryGateway _iCategoryGateway){
        this.iCategoryGateway=_iCategoryGateway;
    }
    @Override
    public List<CategoryDTO> getAllCategories() throws IOException {
        return this.iCategoryGateway.getAllCategories();
    }
}
