package com.example.delivery.product;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductMapper {

    public ProductResponseDto toResponseDto(Product product) {

        ProductResponseDto responseDto = new ProductResponseDto();
        responseDto.setId(product.getId());
        responseDto.setDescription(product.getDescription());
        responseDto.setStoreId(product.getStore().getId());
        responseDto.setPrice(product.getPrice());
        responseDto.setProductType(product.getProductType());
        responseDto.setTitle(product.getTitle());
        responseDto.setExpirationDate(product.getExpirationDate());

        return responseDto;
    }


    public List<ProductResponseDto> toResponseDtoList(List<Product> productList) {
        List<ProductResponseDto> productResponseDtoList = new ArrayList<>();
        for (Product product : productList) {
            productResponseDtoList.add(toResponseDto(product));
        }
        return productResponseDtoList;
    }
}
