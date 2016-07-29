package com.thoughtworks.ketsu.domain.Order;

import com.thoughtworks.ketsu.infrastructure.records.Record;
import com.thoughtworks.ketsu.web.jersey.Routes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zyongliu on 16/7/29.
 */
public class Order implements Record {
    private int id;
    private String name;
    private String address;
    private String phone;
    private String ordertime;
    private List<OrderItem> orderItems;

    @Override
    public Map<String, Object> toRefJson(Routes routes) {
        return new HashMap<String, Object>() {{
            put("uri", "/orders/"+id);
            put("name", name);
            put("address", address);
            put("phone", phone);
            put("create_at", ordertime);
            put("total_price", getTotalPrice());
        }};
    }

    private double getTotalPrice() {
        double totalprice = 0;
        for (OrderItem tmp : orderItems) {
            totalprice += tmp.getAmount();
        }
        return totalprice;
    }

    @Override
    public Map<String, Object> toJson(Routes routes) {
        List<Map<String, Object>> orderitemlist = new ArrayList<Map<String, Object>>();
        Map<String, Object> tojson = toRefJson(routes);
        for (OrderItem tmp : orderItems) {
            orderitemlist.add(tmp.toJson(routes));
        }
        tojson.put("order_Items",orderitemlist);
        return tojson;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
