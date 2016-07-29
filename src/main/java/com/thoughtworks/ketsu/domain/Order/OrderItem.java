package com.thoughtworks.ketsu.domain.Order;

import com.thoughtworks.ketsu.infrastructure.records.Record;
import com.thoughtworks.ketsu.web.jersey.Routes;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zyongliu on 16/7/29.
 */
public class OrderItem implements Record {
    private int orderid;
    private int productid;
    private int quantity;
    private double amount;

    @Override
    public Map<String, Object> toRefJson(Routes routes) {
        return toJson(routes);
    }

    @Override
    public Map<String, Object> toJson(Routes routes) {
        return new HashMap<String, Object>() {{
            put("quantity", quantity);
            put("productid", productid);
            put("amount", amount);
        }};
    }

    public double getAmount() {
        return amount;
    }

    public int getOrderid() {
        return orderid;
    }
}
