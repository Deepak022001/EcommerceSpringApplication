package com.example.EcommerceSpring.Services.cache;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.lang.foreign.Linker.Option;
import java.util.Optional;

import org.springframework.data.redis.core.StringRedisTemplate;

import com.example.EcommerceSpring.Dtos.Response.GetProductResponseDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductRedisCache {
    private static final String PRODUCT_CACHE_PREFIX = "product:name";
    private final StringRedisTemplate stringRedisTemplate;
    private final ObjectMapper objectMapper;

    public Optional<GetProductResponseDto> getSummary(Long id) {
        String responseJson = stringRedisTemplate.opsForValue().get(PRODUCT_CACHE_PREFIX + id);
        if (responseJson == null) {
            return Optional.empty();
        }
        try {
            GetProductResponseDto responseDto = objectMapper.readValue(responseJson, GetProductResponseDto.class);
            return Optional.of(responseDto);
        } catch (Exception e) {
            log.error("Error while fetching product from cache", e);
            stringRedisTemplate.delete(PRODUCT_CACHE_PREFIX + id);
            return Optional.empty();
        }
    }

    private void putSummary(Long id, GetProductResponseDto responseDto) {
        try {
            stringRedisTemplate.opsForValue().set(PRODUCT_CACHE_PREFIX, objectMapper.writeValueAsString(responseDto));
        } catch (Exception e) {
            throw new RuntimeException("Error while putting product in cache" + e.getMessage());
        }
    }

}
