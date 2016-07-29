package com.thoughtworks.ketsu.infrastructure.repositories;

import com.thoughtworks.ketsu.domain.Order.Order;
import com.thoughtworks.ketsu.infrastructure.mybatis.mappers.OrderMapper;
import com.thoughtworks.ketsu.support.DatabaseTestRunner;
import com.thoughtworks.ketsu.support.TestHelper;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import javax.print.attribute.standard.MediaSize;
import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by zyongliu on 16/7/29.
 */
@RunWith(DatabaseTestRunner.class)
public class OrderDOTest {
    @Inject
    UserRepository userRepository;

    @Inject
    ProductRepository productRepository;

    @Inject
    OrderMapper orderMapper;

    @Test
    public void find_order_by_orderid() {
        Map<String, Object> userinfo = TestHelper.userMap();
        userRepository.createUser(userinfo);
        Map<String, Object> productinfo = TestHelper.productmap();
        productRepository.createProduct(productinfo);
        int productid = TestHelper.obj2int(productinfo.get("id"));
        Map<String, Object> orderinfo = TestHelper.orderMap(productid);
        orderMapper.createOrder(orderinfo);
        int orderid = TestHelper.obj2int(orderinfo.get("id"));
        Order order = orderMapper.find_order_by_orderid(orderid);
        assertThat(order.getName(),is("order4"));
    }

    @Test
    public void find_all_orders() {
        Map<String, Object> userinfo = TestHelper.userMap();
        userRepository.createUser(userinfo);
        Map<String, Object> productinfo = TestHelper.productmap();
        productRepository.createProduct(productinfo);
        int productid = TestHelper.obj2int(productinfo.get("id"));
        Map<String, Object> orderinfo = TestHelper.orderMap(productid);
        orderMapper.createOrder(orderinfo);
        List<Order> orderlist = orderMapper.find_all_orders();
        assertThat(orderlist.get(0).getName(),is("order4"));
    }
}
