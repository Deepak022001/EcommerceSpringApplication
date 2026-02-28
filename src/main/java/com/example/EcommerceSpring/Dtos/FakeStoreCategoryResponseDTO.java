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
    private String status;

    private String message;

    private List<String>categories;
}
