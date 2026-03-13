package com.example.EcommerceSpring.Services;

import com.example.EcommerceSpring.Dtos.Request.CreateProductRequestDto;
import com.example.EcommerceSpring.Dtos.Response.GetProductResponseDto;
import com.example.EcommerceSpring.Repository.ProductRepository;
import com.example.EcommerceSpring.Schema.Category;
import com.example.EcommerceSpring.Schema.Product;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceimpl implements ProductService {
    private final ProductRepository iProductRepository;
    private final CategoryService iCategoryService;

    @Override
    public GetProductResponseDto getProductById(Long id) throws IOException {
        Optional<Product> response = iProductRepository.findById(id);
        Product product = response.get();
        return GetProductResponseDto.builder()
                .id(product.getId())
                .title(product.getTitle())
                .description(product.getDescription())
                .price(product.getPrice())
                .image(product.getImage())
                .rating(product.getRating())
                .build();
    }

    @Override
    public List<GetProductResponseDto> getAllProducts() {
        List<Product> responseInProduct = iProductRepository.findAll();
        return responseInProduct.stream()
                .map(
                        product ->
                                GetProductResponseDto.builder()
                                        .id(product.getId())
                                        .title(product.getTitle())
                                        .description(product.getDescription())
                                        .price(product.getPrice())
                                        .image(product.getImage())
                                        .rating(product.getRating())
                                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public GetProductResponseDto getProductWithDetailsById(Long id) {
        Product productResponse = iProductRepository.getProductWithDetailsById(id);
        return GetProductResponseDto.builder()
                .id(productResponse.getId())
                .title(productResponse.getTitle())
                .description(productResponse.getDescription())
                .price(productResponse.getPrice())
                .image(productResponse.getImage())
                .rating(productResponse.getRating())
                .build();
    }

    @Override
    public GetProductResponseDto createProduct(CreateProductRequestDto requestDto) {
        Category category = iCategoryService.getCategoryById(requestDto.getCategoryId());
        Product product =
                Product.builder()
                        .title(requestDto.getTitle())
                        .description(requestDto.getDescription())
                        .image(requestDto.getImage())
                        .price(requestDto.getPrice())
                        .category(category)
                        .rating(requestDto.getRating())
                        .rating(requestDto.getRating())
                        .build();
        Product savedProduct = iProductRepository.save(product);

        return GetProductResponseDto.builder()
                .id(savedProduct.getId())
                .title(savedProduct.getTitle())
                .description(savedProduct.getDescription())
                .price(savedProduct.getPrice())
                .image(savedProduct.getImage())
                .rating(savedProduct.getRating())
                .build();
        //        N+1 problem occurs when fetching a parent entity and its related
        //        entities causes 1 query for the parent and N additional queries for the relations.
        //        2.1 query for parent + N queries for children = N+1 problem
    }

    @Override
    public void deleteById(Long id) {
        iProductRepository.deleteById(id);
    }

    @Override
    public List<Product> getProductsByCategory(String category) {
        return iProductRepository.findByCategory_Name(category);
    }

    @Override
    public List<String> getAllByCategory_Name() {
        return iProductRepository.findAllCategories();
    }
}
