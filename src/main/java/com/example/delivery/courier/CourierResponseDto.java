package com.example.delivery.courier;

import lombok.Data;


@Data
public class CourierResponseDto {

    private int id;
    private String fullName;
    private int addressId;
    private TransportType transportType;
    private boolean busy;

    public CourierResponseDto(int id, String fullName, int addressId, TransportType transportType, boolean busy) {
        this.id = id;
        this.fullName = fullName;
        this.addressId = addressId;
        this.transportType = transportType;
        this.busy = busy;
    }
}
