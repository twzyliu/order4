package com.thoughtworks.ketsu.support;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestHelper {

    public static Map<String, Object> userMap() {
        return new HashMap<String, Object>() {{
            put("name", "zyl");
        }};
    }
    public static Map<String, Object> userfailMap() {
        return new HashMap<String, Object>();
    }

    public static Map<String, Object> productmap() {
        return new HashMap<String, Object>() {{
            put("name", "food");
            put("description", "good");
            put("price", 10);
        }};
    }
    public static Map<String, Object> productfailmap() {
        return new HashMap<String, Object>() {{
            put("name", "food");
            put("price", 10);
        }};
    }
    public static Map<String, Object> orderMap(int productid) {
        return new HashMap<String, Object>() {{
            put("name", "order4");
            put("address", "beijing");
            put("phone", "1234567890");
            put("orderItems", orderItemMap(productid));
        }};
    }
    public static Map<String, Object> orderfailMap(int productid) {
        return new HashMap<String, Object>() {{
            put("name", "order4");
            put("phone", "1234567890");
            put("orderItems", orderItemMap(productid));
        }};
    }
    public static List<Map<String, Object>> orderItemMap(int productid) {
        List<Map<String, Object>> orderitemlist = new ArrayList<Map<String, Object>>();
        Map<String, Object> orderitem = new HashMap<String, Object>() {{
            put("productid", productid);
            put("quantity", 2);
        }};
        orderitemlist.add(orderitem);
        return orderitemlist;
    }

    public static Map<String, Object> paymentMap(int orderid) {
        return new HashMap<String, Object>() {{
            put("orderid",orderid);
            put("pay_type", "CASH");
            put("amount", 100);
        }};
    }

    public static Map<String, Object> paymentfailMap(int orderid) {
        return new HashMap<String, Object>() {{
            put("orderid",orderid);
            put("amount", 100);
        }};
    }

    public static int obj2int(Object object) {
        return Integer.valueOf(String.valueOf(object));
    }
}
