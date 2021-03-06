package com.tw.resource;

import com.tw.json.ProductJson;
import com.tw.mapper.ProductMapper;
import com.tw.model.Product;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Path("/products")
public class ProductResource {
    @Context UriInfo uriInfo;

    @GET
    public String getProducts() {
        return "get products";
    }

    @GET
    @Path("{productId}/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ProductJson getProductById(@PathParam("productId") int id) {
        return new ProductJson(ProductMapper.getProductById(id), uriInfo);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createProduct(Product product) {
        ProductMapper.create(product);
        return Response.status(201).header("location", new ProductJson(product, uriInfo).getUri()).build();
    }

    @PUT
    @Path("{productId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateProduct(@PathParam("productId") int productId, Product product) {
        return Response.status(200).build();
    }

    @Path("{productId}/prices")
    public PriceResource prices(@PathParam("productId") int productId) {
        return new PriceResource();
    }
}
