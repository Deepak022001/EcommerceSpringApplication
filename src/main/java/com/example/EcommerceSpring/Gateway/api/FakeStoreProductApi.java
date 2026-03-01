package com.example.EcommerceSpring.Gateway.api;

import com.example.EcommerceSpring.Dtos.FakeStoreProductResponseDTO;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.io.IOException;
import java.util.List;

public interface FakeStoreProductApi {
    @GET("/products/{id}")
    Call<FakeStoreProductResponseDTO> getAllFakeCategories(@Path("id")Long id) throws IOException;
}
