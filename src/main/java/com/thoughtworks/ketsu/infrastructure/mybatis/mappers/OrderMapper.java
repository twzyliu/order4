package com.thoughtworks.ketsu.infrastructure.mybatis.mappers;

import com.thoughtworks.ketsu.domain.Order.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by zyongliu on 16/7/29.
 */
public interface OrderMapper {
    void createOrder(@Param("info") Map<String ,Object> orderinfo);

    Order find_order_by_orderid(@Param("id") int orderid);

    List<Order> find_all_orders();
}
