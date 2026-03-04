package com.example.EcommerceSpring.mapppers;

import com.example.EcommerceSpring.Dtos.CategoryDTO;
import com.example.EcommerceSpring.Dtos.FakeStoreCategoryResponseDTO;
import com.example.EcommerceSpring.Dtos.FakeStoreProductResponseDTO;
import com.example.EcommerceSpring.Dtos.RatingDTO;

import java.util.List;

public class GetAllCategoriesMapper {
    public static List<CategoryDTO> categoryDTOS(List<FakeStoreCategoryResponseDTO> dtos){
        return dtos.stream().map(dto->CategoryDTO.builder().
                id(dto.getId())
                .title(dto.getTitle())
                .price(dto.getPrice())
                .description(dto.getDescription())
                .category(dto.getCategory())
                .image(dto.getImage())
                .rating(
                        RatingDTO.builder()
                                .rate(dto.getRating().getRate())
                                .count(dto.getRating().getCount())
                        .build()).build()
        ).toList();
    }
}
