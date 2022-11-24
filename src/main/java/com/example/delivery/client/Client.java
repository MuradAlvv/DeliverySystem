package com.example.delivery.client;

import com.example.delivery.address.Address;
import com.example.delivery.client.cart.Cart;
import com.example.delivery.common.BaseIntEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Getter
@Setter
@Entity
public class Client extends BaseIntEntity {

    private String fullName;

    private Cart cart;

    @OneToOne
    private Address location;

}
