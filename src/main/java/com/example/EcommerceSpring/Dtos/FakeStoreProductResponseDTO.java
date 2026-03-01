package com.example.EcommerceSpring.Dtos;

import lombok.*;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class FakeStoreProductResponseDTO {

        private Long id;
        private String title;
        private Double price;
        private String description;
        private String category;
        private String image;
        private Rating rating;

        @Data
        @RequiredArgsConstructor
        @AllArgsConstructor

        public static class Rating {
                private Double rate;
                private Integer count;
        }
}