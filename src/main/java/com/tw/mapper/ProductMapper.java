package com.tw.mapper;

import com.tw.model.Price;
import com.tw.model.Product;

import java.sql.Timestamp;

public class ProductMapper {
    public static Product getProductById(int id) {
        Product product = new Product("product");
        product.setPrice(new Price(100, new Timestamp(0)));
        return product;
    }

    public static void create(Product product) {

    }
}
