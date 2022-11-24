package com.example.delivery.courier;

import com.example.delivery.address.Address;
import com.example.delivery.common.BaseIntEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;

@Getter
@Setter
@Entity
public class Courier extends BaseIntEntity {

    private String fullName;

    @ManyToOne
    private Address location;

    @Enumerated(value = EnumType.STRING)
    private TransportType transportType;

    private boolean busy;

}
