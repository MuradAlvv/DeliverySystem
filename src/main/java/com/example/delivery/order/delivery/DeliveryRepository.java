package com.example.delivery.order.delivery;

import com.example.delivery.courier.Courier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DeliveryRepository extends JpaRepository<Delivery, Integer> {

    Optional<Delivery> findDeliveryByCourier(Courier courier);
}
