package com.example.delivery.product;

import com.example.delivery.common.BaseIntEntity;
import com.example.delivery.store.Store;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Product extends BaseIntEntity {

    private String title;
    private String description;
    private String price;
    private LocalDateTime expirationDate;

    @ManyToOne
    private Store store;

    @Enumerated(value = EnumType.STRING)
    private ProductType productType;


    @Override
    public String toString() {
        return "Product{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", price='" + price + '\'' +
                ", expirationDate=" + expirationDate +
                ", store=" + store +
                ", productType=" + productType +
                '}';
    }
}
