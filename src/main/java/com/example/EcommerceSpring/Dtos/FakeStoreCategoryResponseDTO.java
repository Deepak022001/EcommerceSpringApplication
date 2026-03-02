package com.example.EcommerceSpring.Dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FakeStoreCategoryResponseDTO {
    public int id;
    public String title;
    public double price;
    public String description;
    public String category;
    public String image;
    public RatingDTO rating;
}
