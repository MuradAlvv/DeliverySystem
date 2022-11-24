package com.example.delivery.order;

import com.example.delivery.client.Client;
import com.example.delivery.common.BaseIntEntity;
import com.example.delivery.common.BaseUuidEntity;
import com.example.delivery.delivery.Delivery;
import com.example.delivery.store.Store;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "orders")
public class Order extends BaseUuidEntity {

    @ManyToOne
    private Client author;

    @ManyToOne
    private Store store;

    private String cost;

    @OneToOne
    private Delivery delivery;

}
