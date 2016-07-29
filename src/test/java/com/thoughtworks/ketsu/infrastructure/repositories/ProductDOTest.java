package com.thoughtworks.ketsu.infrastructure.repositories;

import com.thoughtworks.ketsu.domain.Product.Product;
import com.thoughtworks.ketsu.support.DatabaseTestRunner;
import com.thoughtworks.ketsu.support.TestHelper;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by zyongliu on 16/7/29.
 */
@RunWith(DatabaseTestRunner.class)
public class ProductDOTest {
    @Inject
    ProductRepository productRepository;

    @Test
    public void find_product_by_productid() {
        Map<String, Object> productinfo = TestHelper.productmap();
        productRepository.createProduct(productinfo);
        int productid = TestHelper.obj2int(productinfo.get("id"));
        Product product = productRepository.find_product_by_productid(productid);
        assertThat(product.getName(), is("food"));
    }

    @Test
    public void find_all_products() {
        Map<String, Object> productinfo = TestHelper.productmap();
        productRepository.createProduct(productinfo);
        List<Product> productList = productRepository.find_all_products();
        assertThat(productList.get(0).getName(),is("food"));
    }
}
