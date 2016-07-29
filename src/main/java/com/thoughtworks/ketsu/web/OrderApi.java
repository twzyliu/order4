package com.thoughtworks.ketsu.web;

import com.sun.org.apache.xpath.internal.operations.Or;
import com.thoughtworks.ketsu.domain.Order.Order;
import com.thoughtworks.ketsu.infrastructure.mybatis.mappers.OrderMapper;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Map;

/**
 * Created by zyongliu on 16/7/29.
 */
@Path("users/{userid}/orders")
public class OrderApi {
    @Context
    OrderMapper orderMapper;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createOrder(Map<String ,Object>orderinfo) {
        if (orderinfo.get("name") != null && orderinfo.get("address") != null && orderinfo.get("phone")!=null) {
            orderMapper.createOrder(orderinfo);
            return Response.status(201).build();
        }
        else
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
    }

    @Path("{orderid}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Order find_order_by_orderid(@PathParam("orderid") int orderid) {
        Order order = orderMapper.find_order_by_orderid(orderid);
        if(order != null)
            return order;
        else
            throw new WebApplicationException(Response.Status.NOT_FOUND);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Order> find_all_orders() {
        return orderMapper.find_all_orders();
    }

}
