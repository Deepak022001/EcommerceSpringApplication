package com.example.EcommerceSpring.mapppers;
import com.example.EcommerceSpring.Dtos.ProductDTO;
import com.example.EcommerceSpring.Dtos.RatingDTO;
import com.example.EcommerceSpring.Entity.Product;
import com.example.EcommerceSpring.Entity.Rating;

public class ProductMappers {
    public static ProductDTO toDto(Product product){
        return ProductDTO.builder()
                .id(product.getId())
                .title(product.getTitle())
                .price(product.getPrice())
                .description(product.getDescription())
                .category(product.getCategory())
                .image(product.getImage())
                .rating(RatingDTO.builder().rate(product.getRating().getRate()).
                        count(product.getRating().getCount()).build())
                .build();
    }

    public static Product toEntity(ProductDTO productDTO){
        return Product.builder()
                .title(productDTO.getTitle())
                .price(productDTO.getPrice())
                .description(productDTO.getDescription())
                .category(productDTO.getCategory())
                .image(productDTO.getImage())
                .rating(Rating.builder().rate(productDTO.getRating().getRate())
                        .count(productDTO.getRating().getCount())
                        .build())
                .build();
    }
}
