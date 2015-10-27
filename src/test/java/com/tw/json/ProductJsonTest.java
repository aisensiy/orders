package com.tw.json;

import com.tw.model.Product;
import org.junit.Test;

import javax.ws.rs.core.UriInfo;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class ProductJsonTest {
    @Test
    public void should_return_attributes() throws Exception {
        Product product = MockObject.getProduct();
        UriInfo uriInfo = MockObject.getUriInfo();

        ProductJson productJson = new ProductJson(product, uriInfo);
        assertThat(productJson.getName(), is("product"));
        assertThat(productJson.getUri(), is("/products/1"));
        assertThat(productJson.getPrice().getClass().getName(), is("com.tw.json.PriceJson"));
    }
}