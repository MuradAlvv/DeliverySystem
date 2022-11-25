package com.example.delivery.product;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;


    public Page<ProductResponseDto> getPage(int page, int size){
        Pageable pageable = PageRequest.of(page,size);
        return productRepository.getAllProducts(pageable);
    }

    public ProductResponseDto getProductById(int id){
        return productRepository.getProductById(id).orElseThrow();
    }
}
