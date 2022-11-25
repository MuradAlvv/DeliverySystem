package com.example.delivery.client;

import com.example.delivery.client.cart.Cart;
import lombok.Data;

@Data
public class ClientResponseDto {

    private int id;

    private String fullName;

    private Cart cart;

    private int addressId;

    public ClientResponseDto(int id, String fullName, Cart cart, int addressId) {
        this.id = id;
        this.fullName = fullName;
        this.cart = cart;
        this.addressId = addressId;
    }
}
