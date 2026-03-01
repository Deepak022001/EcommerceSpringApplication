package com.example.EcommerceSpring.Gateway;

import com.example.EcommerceSpring.Dtos.FakeStoreProductResponseDTO;
import com.example.EcommerceSpring.Dtos.ProductDTO;
import com.example.EcommerceSpring.Gateway.api.FakeStoreProductApi;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
@RequiredArgsConstructor
@Service
public class FakeStoreProductGateway implements IProductGateway{
private final FakeStoreProductApi fakeStoreProductApi;
    @Override
    public ProductDTO getProductById(Long id) throws IOException {

        FakeStoreProductResponseDTO responseDTO = this.fakeStoreProductApi.getAllFakeCategories(id).execute().body();
        return ProductDTO.builder()
                .id(responseDTO.getId())
                .title(responseDTO.getTitle())
                .price(responseDTO.getPrice())
                .description(responseDTO.getDescription())
                .category(responseDTO.getCategory())
                .image(responseDTO.getImage())
                .rating(ProductDTO.Rating.builder().
                        rate(responseDTO.getRating().getRate())
                        .count(responseDTO.getRating().getCount())
                        .build())
                .build();
    }
}
