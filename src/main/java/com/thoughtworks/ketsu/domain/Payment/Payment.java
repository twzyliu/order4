package com.thoughtworks.ketsu.domain.Payment;

import com.thoughtworks.ketsu.infrastructure.records.Record;
import com.thoughtworks.ketsu.web.jersey.Routes;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zyongliu on 16/7/29.
 */
public class Payment implements Record{
    private int orderid;
    private String pay_type;
    private String pay_time;
    private double amount;

    @Override
    public Map<String, Object> toRefJson(Routes routes) {
        return toJson(routes);
    }

    @Override
    public Map<String, Object> toJson(Routes routes) {
        return new HashMap<String, Object>() {{
            put("order_uri", "orders/"+orderid);
            put("uri", "orders/"+orderid+"/payment");
            put("pay_type", pay_type);
            put("create_at", pay_time);
            put("amount", amount);
        }};
    }

    public int getOrderid() {
        return orderid;
    }

    public String getPay_type() {
        return pay_type;
    }
}
