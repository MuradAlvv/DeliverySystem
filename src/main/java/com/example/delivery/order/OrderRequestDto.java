package com.example.delivery.order;

import com.example.delivery.client.Client;
import com.example.delivery.store.Store;
import lombok.Data;

@Data
public class OrderRequestDto {

    private Client author;
    private Store store;
    private String cost;
}
