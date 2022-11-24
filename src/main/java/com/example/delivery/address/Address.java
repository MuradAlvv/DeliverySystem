package com.example.delivery.address;

import com.example.delivery.city.City;
import com.example.delivery.common.BaseIntEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Getter
@Setter
@Entity
public class Address extends BaseIntEntity {

    @ManyToOne
    private City city;

    private String street;

    private String apartment;

}
