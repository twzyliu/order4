package com.thoughtworks.ketsu.domain.Product;

import com.thoughtworks.ketsu.infrastructure.records.Record;
import com.thoughtworks.ketsu.web.jersey.Routes;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zyongliu on 16/7/29.
 */
public class Product implements Record{
    private int id;
    private String name;
    private String description;
    private double price;

    @Override
    public Map<String, Object> toRefJson(Routes routes) {
        return new HashMap<String, Object>() {{
            put("id", id);
            put("uri", "/products/"+id);
            put("name", name);
            put("address", description);
            put("price", price);
        }};
    }

    @Override
    public Map<String, Object> toJson(Routes routes) {
        return new HashMap<String, Object>() {{
            put("uri", "/products");
            put("name", name);
            put("address", description);
            put("price", price);
        }};
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
