package com.example.delivery.address;

import com.example.delivery.city.CityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AddressMapper {

    private final CityMapper cityMapper;

    public Address toEntity(AddressRequestDto addressRequestDto) {
        Address address = new Address();
        address.setStreet(addressRequestDto.getStreet());
        address.setApartment(addressRequestDto.getApartment());
        address.setCity(cityMapper.toEntity(addressRequestDto.getCityRequestDto()));
        return address;
    }
}
