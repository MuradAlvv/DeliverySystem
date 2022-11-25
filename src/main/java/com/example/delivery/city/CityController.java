package com.example.delivery.city;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cities")
public class CityController {

    private final CityService cityService;

    @GetMapping
    public Page<CityResponseDto> getPage(@RequestParam int page, @RequestParam int size) {
        return cityService.getCities(page, size);
    }

    @PostMapping
    public void create(@RequestBody CityRequestDto cityRequestDto) {
        cityService.create(cityRequestDto);
    }
}
