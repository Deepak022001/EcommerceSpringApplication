package com.example.EcommerceSpring.Services;

import com.example.EcommerceSpring.Dtos.CategoryDTO;
import com.example.EcommerceSpring.Dtos.ProductDTO;
import com.example.EcommerceSpring.Gateway.ICategoryGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class FakeStoreCategoryService implements ICategoryService {
private  ICategoryGateway iCategoryGateway;
public FakeStoreCategoryService(@Qualifier("FakeStoreRestTemplateGateway") ICategoryGateway iCategoryGateway){
    this.iCategoryGateway=iCategoryGateway;
}
    @Override
    public List<CategoryDTO> getAllCategories() throws IOException {
        return this.iCategoryGateway.getAllCategories();
    }
}
