package com.example.EcommerceSpring.Controller;
import com.example.EcommerceSpring.Dtos.Request.CreateCategoryRequestDto;
import com.example.EcommerceSpring.Schema.Category;
import com.example.EcommerceSpring.Services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/categories")
public class CategoryController {

private final CategoryService iCategoryService;

@PostMapping
    public Category createProduct(@RequestBody CreateCategoryRequestDto createCategoryRequestDto){
    return iCategoryService.createProduct(createCategoryRequestDto);
}

}
