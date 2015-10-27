package com.tw.json;

import com.tw.model.Price;
import com.tw.model.Product;
import org.junit.Test;

import javax.ws.rs.core.UriInfo;
import java.net.URI;
import java.sql.Timestamp;
import java.util.Date;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PriceJsonTest {
    @Test
    public void should_return_attributes() throws Exception {
        long time = 1445855037568L;
        Timestamp timestamp = new Timestamp(time);
        Price price = MockObject.getPrice(timestamp);
        UriInfo uriInfo = MockObject.getUriInfo();

        Product product = MockObject.getProduct();
        PriceJson priceJson = new PriceJson(product, price, uriInfo);
        assertThat(priceJson.getPrice(), is(100));
        assertThat(priceJson.getUri(), is("/products/1/prices/1"));
        assertThat(priceJson.getCreatedAt(), is(time));
    }
}