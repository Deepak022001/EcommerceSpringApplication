package com.example.EcommerceSpring.Gateway;

import com.example.EcommerceSpring.Dtos.CategoryDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;
@RequiredArgsConstructor
@Component("FakeStoreRestTemplateGateway")
public class FakeStoreRestTemplateGateway implements ICategoryGateway{
    private  final RestTemplate restTemplate;
    @Override
    public List<CategoryDTO> getAllCategories() throws IOException {
        String url="https://fakestoreapi.com/products/";
        ResponseEntity<List<CategoryDTO>>responses=
                restTemplate.exchange(
                        url,
                        HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference<List<CategoryDTO>>() {
                        }
                );
        return responses.getBody();
    }
}
