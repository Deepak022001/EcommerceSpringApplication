package com.example.EcommerceSpring.Gateway;

import com.example.EcommerceSpring.Dtos.CategoryDTO;
import com.example.EcommerceSpring.Dtos.FakeStoreCategoryResponseDTO;
import com.example.EcommerceSpring.Gateway.api.FakeStoreCategoryApi;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class FakeStoreCategoryGateway implements ICategoryGateway{

    private final FakeStoreCategoryApi fakeStoreCategoryApi;

    public FakeStoreCategoryGateway(FakeStoreCategoryApi fakeStoreCategoryApi1){
        this.fakeStoreCategoryApi=fakeStoreCategoryApi1;
    }
    @Override
    public List<CategoryDTO> getAllCategories() throws IOException {

        List<String> categories =
                this.fakeStoreCategoryApi
                        .getAllFakeCategories()
                        .execute()
                        .body();

        if (categories == null) {
            throw new IOException("failed to fetch");
        }

        return categories.stream()
                .map(category ->
                        CategoryDTO.builder()
                                .name(String.valueOf(category))
                                .build())
                .toList();
    }
}
