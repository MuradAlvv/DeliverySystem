package com.example.delivery.order.delivery;

import com.example.delivery.address.Address;
import com.example.delivery.courier.Courier;
import com.example.delivery.courier.CourierRepository;
import com.example.delivery.courier.CourierService;
import com.example.delivery.courier.TransportType;
import com.example.delivery.order.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeliveryService {

    private final DeliveryRepository deliveryRepository;

    private final CourierService courierService;

    private final CourierRepository courierRepository;
    private static long start;

    public void beginDeliver(Order order) {
        start = System.currentTimeMillis();
        Address storeAddress = order.getStore().getAddress();
        Delivery delivery = new Delivery();
        Courier closestCourier = courierService.findClosestCourier(storeAddress);
        delivery.setCourier(closestCourier);
        delivery.setDeliveryStatus(DeliveryStatus.IN_PROGRESS);
        delivery.setDistance("6 km");
        delivery.setApproximateDeliveryTime(calculateDeliveryTime(delivery));

        deliveryRepository.save(delivery);
        order.setDelivery(delivery);
    }

    public String calculateDeliveryTime(Delivery delivery) {
        Courier courier = delivery.getCourier();
        TransportType transportType = courier.getTransportType();
        String distance = delivery.getDistance();
        double time = 0;
        switch (transportType) {
            case CAR -> time = Integer.parseInt(distance.split(" ")[0]) / 60.0;
            case BIKE -> time = Integer.parseInt(distance.split(" ")[0]) / 70.0;
            case BICYCLE -> time = Integer.parseInt(distance.split(" ")[0]) / 20.0;
        }
        return time * 60 + " min";
    }

    public void endDelivery(Courier courier) {
        long end = System.currentTimeMillis();

        Delivery delivery = findDeliveryByCourier(courier);
        delivery.setDeliveryStatus(DeliveryStatus.DELIVERED);
        delivery.setDeliveryTime((end - start) + "");
        save(delivery);

        courier.setBusy(false);
        courierService.save(courier);


    }

    public Delivery findDeliveryByCourier(Courier courier) {
        return deliveryRepository.findDeliveryByCourier(courier).orElseThrow();
    }

    public void save(Delivery delivery) {
        deliveryRepository.save(delivery);
    }

    public void finishDeliver(int courierId){
        Courier courier = courierRepository.findById(courierId).orElseThrow();
        endDelivery(courier);
    }

}
