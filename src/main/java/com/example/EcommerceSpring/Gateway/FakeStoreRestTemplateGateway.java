package com.example.EcommerceSpring.Gateway;

import com.example.EcommerceSpring.Dtos.CategoryDTO;
import com.example.EcommerceSpring.Dtos.FakeStoreCategoryResponseDTO;
import com.example.EcommerceSpring.Dtos.RatingDTO;
import com.example.EcommerceSpring.mapppers.GetAllCategoriesMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;


import java.io.IOException;
import java.util.List;
@RequiredArgsConstructor
@Component("FakeStoreRestTemplateGateway")
public class FakeStoreRestTemplateGateway implements ICategoryGateway{
    private final RestTemplateBuilder restTemplateBuilder;
    @Override
    public List<CategoryDTO> getAllCategories() throws IOException {

        RestTemplate restTemplate = new RestTemplate();

        String url = "https://fakestoreapi.com/products/";

        ResponseEntity<List<FakeStoreCategoryResponseDTO>> response =
                restTemplate.exchange(
                        url,
                        HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference<List<FakeStoreCategoryResponseDTO>>() {}
                );

        if (response.getBody() == null) {
            throw new IOException("Failed to fetch categories from FakeStore Api");
        }
        return GetAllCategoriesMapper.categoryDTOS(response.getBody());
        }
    }
