package com.tw.model;

public class Product {
    private int id;
    private String name;
    private Price price;

    public Product(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Price getPrice() {
        return price;
    }

    public int getId() {
        return id;
    }
}
