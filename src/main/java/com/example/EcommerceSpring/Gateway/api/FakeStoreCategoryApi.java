package com.example.EcommerceSpring.Gateway.api;
import com.example.EcommerceSpring.Dtos.CategoryDTO;
import com.example.EcommerceSpring.Dtos.FakeStoreCategoryResponseDTO;
import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

public interface FakeStoreCategoryApi {
    @GET("products/categories")
    Call<List<String>> getAllFakeCategories();
}
