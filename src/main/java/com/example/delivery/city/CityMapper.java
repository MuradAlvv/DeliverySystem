package com.example.delivery.city;

import org.springframework.stereotype.Component;

@Component
public class CityMapper {

    public City toEntity(CityRequestDto cityRequestDto){
        City city = new City();
        city.setName(cityRequestDto.getName());
        return city;
    }
}
