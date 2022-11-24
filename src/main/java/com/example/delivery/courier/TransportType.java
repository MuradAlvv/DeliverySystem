package com.example.delivery.courier;

public enum TransportType {

    CAR("Автомобиль"),
    BIKE("Мотоцикл"),
    BICYCLE("Велосипед");

    private String value;

    TransportType(String value) {
        this.value = value;
    }
}
