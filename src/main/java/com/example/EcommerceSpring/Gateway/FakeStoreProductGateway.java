package com.example.EcommerceSpring.Gateway;

import com.example.EcommerceSpring.Dtos.FakeStoreProductResponseDTO;
import com.example.EcommerceSpring.Dtos.ProductDTO;
import com.example.EcommerceSpring.Dtos.RatingDTO;
import com.example.EcommerceSpring.Gateway.api.FakeStoreProductApi;
import com.example.EcommerceSpring.mapppers.GetAllProductsMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;

@RequiredArgsConstructor
@Service
public class FakeStoreProductGateway implements IProductGateway {

    private final FakeStoreProductApi fakeStoreProductApi;

    @Override
    public ProductDTO getProductById(Long id) throws IOException {

        FakeStoreProductResponseDTO responseDTO =
                this.fakeStoreProductApi.
                        getAllFakeCategories(id)
                        .execute()
                        .body();

        if (responseDTO == null) {
            throw new IOException("Failed to fetch product");
        }

//
        return GetAllProductsMapper.productDTO(responseDTO);
    }
}