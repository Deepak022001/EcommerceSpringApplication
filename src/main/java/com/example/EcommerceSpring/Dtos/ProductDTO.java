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
    public Rating rating;
    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Rating{
        public double rate;
        public int count;
    }
}

