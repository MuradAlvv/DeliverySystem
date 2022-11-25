package com.example.delivery.product;

import com.example.delivery.store.Store;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ProductResponseDto {

    private int id;
    private String title;
    private String description;
    private String price;
    private LocalDateTime expirationDate;
    private Store store;
    private ProductType productType;

    public ProductResponseDto(int id, String title, String description,
                              String price, LocalDateTime expirationDate,
                              Store store, ProductType productType) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.price = price;
        this.expirationDate = expirationDate;
        this.store = store;
        this.productType = productType;
    }
}
