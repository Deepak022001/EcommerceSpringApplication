package com.example.EcommerceSpring.Services;

import com.example.EcommerceSpring.Dtos.ProductDTO;
import com.example.EcommerceSpring.Gateway.IProductGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
@Service
@RequiredArgsConstructor
public class FakeStoreProductService implements IProductService{
private final IProductGateway iProductGateway;
    @Override
    public ProductDTO getProductById(Long id) throws IOException {
        return this.iProductGateway.getProductById(id);
    }
}
