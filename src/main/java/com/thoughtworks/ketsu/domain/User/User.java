package com.thoughtworks.ketsu.domain.User;

import com.thoughtworks.ketsu.infrastructure.records.Record;
import com.thoughtworks.ketsu.web.jersey.Routes;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zyongliu on 16/7/29.
 */
public class User implements Record{
    private int id;
    private String name;


    @Override
    public Map<String, Object> toRefJson(Routes routes) {
        return new HashMap<String, Object>() {{
            put("uri", "/users/"+id);
            put("name", name);
            put("id", id);
        }};
    }

    @Override
    public Map<String, Object> toJson(Routes routes) {
        return toRefJson(routes);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
