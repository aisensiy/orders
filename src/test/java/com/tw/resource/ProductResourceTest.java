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
        return new ResourceConfig(ProductResource.class);
    }

    @Test
    public void should_get_product_list() throws Exception {
        final String productList = target("/products").request().get(String.class);
        assertThat(productList, is("get products"));
    }

    @Test
    public void should_get_product_by_id() throws Exception {
        Response response = target("/products/id").request().get();
        assertThat(response.getStatus(), is(200));
        Map product = response.readEntity(Map.class);
        assertThat(product.get("name"), is("product1"));
        assertThat((String) product.get("uri"), endsWith("products/0"));
    }

    @Test
    public void should_create_product_with_status_201() throws Exception {
        Response response = target("/products").request().post(Entity.json("{\"name\":\"product\"}"));
        assertThat(response.getStatus(), is(201));
    }

    @Test
    public void should_update_product() throws Exception {
        Response response = target("/products/id").request().put(Entity.json("{\"name\":\"product\"}"));
        assertThat(response.getStatus(), is(200));
    }
}
