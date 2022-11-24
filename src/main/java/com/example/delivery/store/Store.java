package com.example.delivery.store;

import com.example.delivery.address.Address;
import com.example.delivery.common.BaseIntEntity;
import com.example.delivery.product.Product;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

@Getter
@Setter
@Entity
public class Store extends BaseIntEntity {

    private String name;

    @OneToOne
    private Address address;

    @OneToMany
    private List<Product> products;
}
