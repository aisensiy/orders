package com.tw.json;

import com.tw.model.Price;
import com.tw.model.Product;

import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Timestamp;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MockObject {
    public static Price getPrice(Timestamp timestamp) {
        Price price;
        price = mock(Price.class);
        when(price.getId()).thenReturn(1);
        when(price.getCreatedAt()).thenReturn(timestamp);
        when(price.getPrice()).thenReturn(100);
        return price;
    }

    public static Product getProduct() {
        Product product = mock(Product.class);
        when(product.getId()).thenReturn(1);
        when(product.getName()).thenReturn("product");
        return product;
    }

    public static UriInfo getUriInfo() throws URISyntaxException {
        UriInfo uriInfo = mock(UriInfo.class);
        when(uriInfo.getBaseUriBuilder()).thenReturn(UriBuilder.fromPath(""));
        return uriInfo;
    }
}
