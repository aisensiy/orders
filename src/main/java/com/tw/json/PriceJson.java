package com.tw.json;

import com.tw.model.Price;
import com.tw.model.Product;
import com.tw.resource.ProductResource;

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
        return uriInfo.getBaseUriBuilder()
                .path(ProductResource.class)
                .path("/" + product.getId())
                .path("/prices")
                .path("/" + price.getId())
                .build().toString();
    }

    public int getPrice() {
        return price.getPrice();
    }

    public long getCreatedAt() {
        return price.getCreatedAt().getTime();
    }
}
