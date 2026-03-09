package com.example.EcommerceSpring.Services;

import com.example.EcommerceSpring.Dtos.Request.CreateCategoryRequestDto;
import com.example.EcommerceSpring.Repository.ICategoryRepository;
import com.example.EcommerceSpring.Repository.IProductRepository;
import com.example.EcommerceSpring.Schema.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceimpl implements CategoryService {
    private final IProductRepository iProductRepository;
    private final ICategoryRepository iCategoryRepository;
    @Override
    public List<CreateCategoryRequestDto> getAllCategories() throws IOException {
        return List.of();
    }

    @Override
    public Category getCategoryById(Long id) {
        Category category= iCategoryRepository
                .findById(id).orElseThrow(()->new RuntimeException("Category Not found"));
        return category;
    }

    @Override
    public Category createProduct(CreateCategoryRequestDto createCategoryRequestDto) {
        Category category=Category.builder()
                .name(createCategoryRequestDto.getName()).build();
        return iCategoryRepository.save(category);
    }

}
