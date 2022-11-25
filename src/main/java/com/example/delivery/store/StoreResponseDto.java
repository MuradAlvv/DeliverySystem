package com.example.delivery.store;


import com.example.delivery.product.ProductResponseDto;
import lombok.Data;

import java.util.List;

@Data
public class StoreResponseDto {

    private int id;
    private String name;
    private int addressId;
    private List<ProductResponseDto> productResponseDtoList;

}
