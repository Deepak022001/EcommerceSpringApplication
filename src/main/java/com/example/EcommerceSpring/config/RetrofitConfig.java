package com.example.EcommerceSpring.config;

import com.example.EcommerceSpring.Gateway.api.FakeStoreCategoryApi;
import com.google.gson.Gson;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Configuration
public class RetrofitConfig {

    // 1. We create the Retrofit builder as a private helper
    @Bean
    public Retrofit retrofit() {
        return new Retrofit.Builder()
                .baseUrl("https://fakestoreapi.com/")
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .build();
    }
    // 2. This @Bean method provides the FakeStoreCategoryApi to Spring
    @Bean
    public FakeStoreCategoryApi fakeStoreCategoryApi() {
        return retrofit().create(FakeStoreCategoryApi.class);
    }
}