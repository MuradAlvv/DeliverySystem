package com.example.delivery.product;

import com.example.delivery.store.Store;
import com.example.delivery.store.StoreResponseDto;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class ProductResponseDto {

    private int id;
    private String title;
    private String description;
    private String price;
    private LocalDateTime expirationDate;
    private int storeId;
    private ProductType productType;

    public ProductResponseDto(int id, String title, String description,
                              String price, LocalDateTime expirationDate,
                              int storeId, ProductType productType) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.price = price;
        this.expirationDate = expirationDate;
        this.storeId = storeId;
        this.productType = productType;
    }
}
