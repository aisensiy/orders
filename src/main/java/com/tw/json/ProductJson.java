package com.tw.json;

import com.tw.model.Product;
import com.tw.resource.ProductResource;

import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

public class ProductJson {

    private Product product;
    private UriInfo uriInfo;
    private PriceJson price;

    public ProductJson(Product product, UriInfo uriInfo) {
        this.product = product;
        this.uriInfo = uriInfo;
    }

    public String getName() {
        return product.getName();
    }

    public String getUri() {
        UriBuilder baseUriBuilder = uriInfo.getBaseUriBuilder();
        UriBuilder path = baseUriBuilder.path(ProductResource.class);
        return path.build().toString() + "/" + product.getId();
    }

    public PriceJson getPrice() {
        return new PriceJson(product, product.getPrice(), uriInfo);
    }
}
