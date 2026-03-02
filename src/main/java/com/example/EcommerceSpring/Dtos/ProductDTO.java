package com.example.EcommerceSpring.Dtos;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class ProductDTO{
    public Long id;
    public String title;
    public double price;
    public String description;
    public String category;
    public String image;
    public RatingDTO rating;
}

