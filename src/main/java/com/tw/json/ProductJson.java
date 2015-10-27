package com.tw.json;

import com.tw.model.Product;
import com.tw.resource.ProductResource;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

public class ProductJson {
    UriInfo uriInfo;
    private Product product;

    public ProductJson(Product product, UriInfo uriInfo) {
        this.product = product;
        this.uriInfo = uriInfo;
    }

    public String getName() {
        return product.getName();
    }

    public String getUri() {
        return uriInfo.getBaseUriBuilder().path(ProductResource.class).path("/" + product.getId()).toString();
    }

    public PriceJson getPrice() {
        return new PriceJson(product, product.getPrice(), uriInfo);
    }
}
