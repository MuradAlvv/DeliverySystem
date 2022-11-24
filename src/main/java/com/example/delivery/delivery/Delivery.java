package com.example.delivery.delivery;

import com.example.delivery.common.BaseUuidEntity;
import com.example.delivery.courier.Courier;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;

@Getter
@Setter
@Entity
public class Delivery extends BaseUuidEntity {

    @ManyToOne
    private Courier courier;

    private String distance;

    private String approximateDeliveryTime;

    private String deliveryTime;

    @Enumerated(value = EnumType.STRING)
    private DeliveryStatus deliveryStatus;

}
