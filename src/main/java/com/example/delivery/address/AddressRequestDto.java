package com.example.delivery.address;

import com.example.delivery.city.City;
import com.example.delivery.city.CityRequestDto;
import lombok.Data;

@Data
public class AddressRequestDto {

    private CityRequestDto cityRequestDto;

    private String street;

    private String apartment;
}
