package com.tw.model;

import java.sql.Timestamp;

public class Price {
    private int id;
    private int price;
    private Timestamp createdAt;

    public Price(int price, Timestamp createdAt) {
        this.price = price;
        this.createdAt = createdAt;
    }

    public int getPrice() {
        return price;
    }

    public int getId() {
        return id;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }
}
