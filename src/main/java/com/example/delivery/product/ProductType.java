package com.example.delivery.product;

public enum ProductType {
    FRUIT("Фрукты"),
    VEGETABLES("Овощи"),
    GRAINS("Злаки"),
    DAIRY("Молочные продукты");

    private String value;

    ProductType(String value) {
        this.value = value;
    }
}
