package com.example.EcommerceSpring.Gateway;

import com.example.EcommerceSpring.Dtos.CategoryDTO;
import com.example.EcommerceSpring.Dtos.FakeStoreCategoryResponseDTO;
import com.example.EcommerceSpring.Dtos.FakeStoreProductResponseDTO;
import com.example.EcommerceSpring.Dtos.RatingDTO;
import com.example.EcommerceSpring.Gateway.api.FakeStoreCategoryApi;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
@RequiredArgsConstructor
public class FakeStoreCategoryGateway implements ICategoryGateway{
    private final FakeStoreCategoryApi fakeStoreCategoryApi;
    @Override
    public List<CategoryDTO> getAllCategories() throws IOException {
        List<FakeStoreCategoryResponseDTO> response =
                this.fakeStoreCategoryApi
                        .getAllFakeCategories()
                        .execute()
                        .body();
        if (response == null) {
            throw new IOException("failed to fetch");
        }
        return response.stream()
                .map(product ->
                        CategoryDTO.builder()
                                .id(product.getId())
                                .title(product.getTitle())
                                .price(product.getPrice())
                                .description(product.getDescription())
                                .category(product.getCategory())
                                .image(product.getImage())
                                .rating(
                                        RatingDTO.builder()
                                                .rate(product.getRating().getRate())
                                                .count(product.getRating().getCount())
                                                .build()
                                )
                                .build()
                )
                .toList();
    }
}