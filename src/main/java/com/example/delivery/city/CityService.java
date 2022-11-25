package com.example.delivery.city;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CityService {

    private final CityRepository cityRepository;

    public void create(CityRequestDto cityRequestDto) {
        City city = new City();
        city.setName(cityRequestDto.getName());
        cityRepository.save(city);
    }

    public Page<CityResponseDto> getCities(int page, int size) {
        return cityRepository.getAllCities(page, size);
    }
}
