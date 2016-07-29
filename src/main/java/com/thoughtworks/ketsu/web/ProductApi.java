package com.thoughtworks.ketsu.web;

import com.thoughtworks.ketsu.domain.Product.Product;
import com.thoughtworks.ketsu.infrastructure.repositories.ProductRepository;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Map;

/**
 * Created by zyongliu on 16/7/29.
 */
@Path("products")
public class ProductApi {
    @Context
    ProductRepository productRepository;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createProduct(Map<String,Object> productinfo) {
        if (productinfo.get("name") != null && productinfo.get("description") != null &&  productinfo.get("price") != null) {
            productRepository.createProduct(productinfo);
            return Response.status(201).build();
        }else
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
    }

    @Path("{productid}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Product find_product_by_productid(@PathParam("productid") int productid) {
        Product product = productRepository.find_product_by_productid(productid);
        if(product!=null)
            return product;
        else
            throw new WebApplicationException(Response.Status.NOT_FOUND);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Product> find_all_products() {
        return productRepository.find_all_products();
    }
}
