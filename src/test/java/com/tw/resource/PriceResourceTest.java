package com.tw.resource;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class PriceResourceTest extends JerseyTest {
    @Override
    protected Application configure() {
        return new ResourceConfig().packages("com.tw");
    }

    @Test
    public void should_get_prices() throws Exception {
        String response = target("/products/1/prices").request().get(String.class);
        assertThat(response, is("prices"));
    }

    @Test
    public void should_create_new_price() throws Exception {
        Response response = target("/products/1/prices").request().post(Entity.json("{\"price\":123}"));
        assertThat(response.getStatus(), is(201));
    }
}