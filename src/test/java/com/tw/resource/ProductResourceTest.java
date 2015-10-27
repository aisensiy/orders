package com.tw.resource;

import com.tw.resource.ProductResource;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.*;

import java.util.Map;

import static org.hamcrest.CoreMatchers.endsWith;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ProductResourceTest extends JerseyTest {

    @Override
    protected Application configure() {
        return new ResourceConfig().packages("com.tw");
    }

    @Test
    public void should_get_product_list() throws Exception {
        final Response response = target("/products").request().get();
        assertThat(response.getStatus(), is(200));
    }

    @Test
    public void should_get_product_by_id() throws Exception {
        Response response = target("/products/1").request().get();
        assertThat(response.getStatus(), is(200));
    }

    @Test
    public void should_create_product_with_status_201() throws Exception {
        Response response = target("/products").request().post(Entity.json("{\"name\":\"product\"}"));
        assertThat(response.getStatus(), is(201));
    }

    @Test
    public void should_update_product() throws Exception {
        Response response = target("/products/1").request().put(Entity.json("{\"name\":\"product\"}"));
        assertThat(response.getStatus(), is(200));
    }
}
