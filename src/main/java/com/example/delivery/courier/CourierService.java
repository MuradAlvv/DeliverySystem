package com.example.delivery.courier;

import com.example.delivery.address.Address;
import com.example.delivery.city.City;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class CourierService {

    private final CourierRepository courierRepository;

    public Courier findClosestCourier(Address address) {
        City city = address.getCity();
        List<Courier> courierList = courierRepository.findCourierByLocation(city);
        Courier courier = courierList.get(new Random().nextInt(courierList.size()));
        courier.setBusy(true);
        courierRepository.save(courier);
        return courier;
    }

    public void save(Courier courier) {
        courierRepository.save(courier);
    }

}
