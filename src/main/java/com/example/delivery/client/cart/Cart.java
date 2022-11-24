package com.example.delivery.client.cart;

import com.example.delivery.product.Product;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;

@Getter
@Setter
@Embeddable
public class Cart {

    @OneToMany(fetch = FetchType.EAGER)
    private List<Product> productList;
    private String cost;

    public void add(Product product) {
        productList.add(product);
    }

    public double getTotalCost() {
        return productList.stream().map(Product::getPrice).map(Double::valueOf).reduce((a, b) -> a + b).get();
    }

}
