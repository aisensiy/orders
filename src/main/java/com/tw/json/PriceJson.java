package com.tw.json;

import com.tw.model.Price;
import com.tw.model.Product;

import javax.ws.rs.core.UriInfo;

public class PriceJson {
    private Product product;
    private final Price price;
    private final UriInfo uriInfo;

    public PriceJson(Product product, Price price, UriInfo uriInfo) {
        this.product = product;
        this.price = price;
        this.uriInfo = uriInfo;
    }

    public String getUri() {
        return uriInfo.getBaseUri() + "products/" + product.getId() + "/prices/" + price.getId();
    }

    public int getPrice() {
        return price.getPrice();
    }

    public long getCreatedAt() {
        return price.getCreatedAt().getTime();
    }
}
