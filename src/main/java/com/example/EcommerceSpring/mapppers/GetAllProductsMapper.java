package com.example.EcommerceSpring.mapppers;

import com.example.EcommerceSpring.Dtos.FakeStoreCategoryResponseDTO;
import com.example.EcommerceSpring.Dtos.FakeStoreProductResponseDTO;
import com.example.EcommerceSpring.Dtos.ProductDTO;
import com.example.EcommerceSpring.Dtos.RatingDTO;

public class GetAllProductsMapper {
    public static ProductDTO productDTO(FakeStoreProductResponseDTO responseDTO ){
        return ProductDTO.builder()
                .id(responseDTO.getId()).title(responseDTO.getTitle())
                .price(responseDTO.getPrice())
                .description(responseDTO.getDescription())
                .category(responseDTO.getCategory())
                .image(responseDTO.getImage())
                .rating(
                        RatingDTO.builder()
                                .rate(responseDTO.getRating().getRate())
                        .count(responseDTO.getRating().getCount())
                                .build())
                .build();
    }
}
