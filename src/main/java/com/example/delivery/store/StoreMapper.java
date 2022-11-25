package com.example.delivery.store;

import com.example.delivery.product.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StoreMapper {

    private final ProductMapper productMapper;

    public StoreResponseDto toResponseDto(Store store) {
        StoreResponseDto dto = new StoreResponseDto();
        dto.setId(store.getId());
        dto.setName(store.getName());
        dto.setAddressId(store.getAddress().getId());
        dto.setProductResponseDtoList(productMapper.toResponseDtoList(store.getProducts()));
        return dto;
    }
}
