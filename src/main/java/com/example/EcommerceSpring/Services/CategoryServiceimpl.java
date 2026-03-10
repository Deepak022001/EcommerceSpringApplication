package com.example.EcommerceSpring.Services;

import com.example.EcommerceSpring.Dtos.Request.CreateCategoryRequestDto;
import com.example.EcommerceSpring.Repository.CategoryRepository;
import com.example.EcommerceSpring.Repository.ProductRepository;
import com.example.EcommerceSpring.Schema.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceimpl implements CategoryService {
    private final ProductRepository iProductRepository;
    private final CategoryRepository iCategoryRepository;
    @Override
    public Category createCategory(CreateCategoryRequestDto createCategoryRequestDto) {
        Category category=Category.builder()
                .name(createCategoryRequestDto.getName()).build();
        return iCategoryRepository.save(category);
    }
    
    @Override
    public List<Category> getAllCategories() throws IOException {
        return iCategoryRepository.findAll();
    }

    @Override
    public Category getCategoryById(Long id) {
        Category category= iCategoryRepository.findById(id).orElse(null);
        return category;
    }

        @Override
        public void deleteCategoryById(Long id) {
            if(iProductRepository.existsByCategory_Id(id)){
                throw new RuntimeException("Cannot delete category because products exist");
            }
            Category category = iCategoryRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Category not found"));

            category.setDeletedAt(LocalDateTime.now());

            iCategoryRepository.save(category);
        }
    }
