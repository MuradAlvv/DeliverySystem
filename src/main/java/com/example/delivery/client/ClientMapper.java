package com.example.delivery.client;

import com.example.delivery.address.AddressMapper;
import com.example.delivery.client.cart.Cart;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ClientMapper {


    private final AddressMapper addressMapper;

    public Client toEntity(ClientRequestDto clientRequestDto) {
        Client client = new Client();
        client.setFullName(clientRequestDto.getFullName());
        client.setLocation(addressMapper.toEntity(clientRequestDto.getAddressRequestDto()));
        client.setCart(new Cart());
        return client;
    }
}
