package com.thoughtworks.ketsu.infrastructure.repositories;

import com.thoughtworks.ketsu.domain.Payment.Payment;
import com.thoughtworks.ketsu.infrastructure.mybatis.mappers.OrderMapper;
import com.thoughtworks.ketsu.infrastructure.mybatis.mappers.PaymentMapper;
import com.thoughtworks.ketsu.support.DatabaseTestRunner;
import com.thoughtworks.ketsu.support.TestHelper;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import javax.print.attribute.standard.MediaSize;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by zyongliu on 16/7/29.
 */
@RunWith(DatabaseTestRunner.class)
public class PaymentDOTest {
    @Inject
    UserRepository userRepository;

    @Inject
    ProductRepository productRepository;

    @Inject
    OrderMapper orderMapper;

    @Inject
    PaymentMapper paymentMapper;

    @Test
    public void find_payment_by_orderid() {
        Map<String, Object> userinfo = TestHelper.userMap();
        userRepository.createUser(userinfo);
        int userid = TestHelper.obj2int(userinfo.get("id"));
        Map<String, Object> productinfo = TestHelper.productmap();
        productRepository.createProduct(productinfo);
        int productid = TestHelper.obj2int(productinfo.get("id"));
        Map<String, Object> orderinfo = TestHelper.orderMap(productid);
        orderMapper.createOrder(orderinfo);
        int orderid = TestHelper.obj2int(orderinfo.get("id"));
        paymentMapper.createPayment(TestHelper.paymentMap(orderid),orderid);
        Payment payment = paymentMapper.find_payment_by_orderid(orderid);
        assertThat(payment.getPay_type(),is("CASH"));
    }
}
