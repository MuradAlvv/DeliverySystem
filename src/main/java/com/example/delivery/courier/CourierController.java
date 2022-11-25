package com.example.delivery.courier;

import com.example.delivery.delivery.DeliveryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/couriers")
public class CourierController {

    private final CourierService courierService;

    @GetMapping
    public Page<CourierResponseDto> getPage(@RequestParam int page, @RequestParam int size) {
        return courierService.getPage(page, size);
    }

    @GetMapping("/{id}")
    public CourierResponseDto getById(@PathVariable int id) {
        return courierService.getCourierById(id);
    }

    @PostMapping("/end/{courierId}")
    public void endDeliver(@PathVariable int courierId) {
        courierService.finishDeliver(courierId);
    }
}
