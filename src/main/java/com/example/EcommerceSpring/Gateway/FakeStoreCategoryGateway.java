package com.example.EcommerceSpring.Gateway;

import com.example.EcommerceSpring.Dtos.CategoryDTO;
import com.example.EcommerceSpring.Dtos.FakeStoreCategoryResponseDTO;
import com.example.EcommerceSpring.Dtos.FakeStoreProductResponseDTO;
import com.example.EcommerceSpring.Dtos.RatingDTO;
import com.example.EcommerceSpring.Gateway.api.FakeStoreCategoryApi;
import com.example.EcommerceSpring.mapppers.GetAllCategoriesMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component("FakeStoreCateogoryGateway")
@RequiredArgsConstructor
public class FakeStoreCategoryGateway implements ICategoryGateway{

    private final FakeStoreCategoryApi fakeStoreCategoryApi;
    @Override
    public List<CategoryDTO> getAllCategories() throws IOException {
        List<FakeStoreCategoryResponseDTO> response =
                this.fakeStoreCategoryApi
                        .getAllFakeCategories()
                        .execute()
                        .body();
        if (response == null) {
            throw new IOException("failed to fetch");
        }
        return GetAllCategoriesMapper.categoryDTOS(response);
    }
}