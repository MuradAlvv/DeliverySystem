package com.example.delivery.city;

import com.example.delivery.common.BaseIntEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
@Entity
public class City extends BaseIntEntity {

    private String name;
}
