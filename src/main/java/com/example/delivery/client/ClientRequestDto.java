package com.example.delivery.client;

import com.example.delivery.address.AddressRequestDto;
import com.example.delivery.client.cart.Cart;
import lombok.Data;

@Data
public class ClientRequestDto {

    private String fullName;
    private AddressRequestDto addressRequestDto;
}
