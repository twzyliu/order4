package com.thoughtworks.ketsu.domain.Product;

import java.util.List;
import java.util.Map;

/**
 * Created by zyongliu on 16/7/29.
 */
public interface ProductInterface {
    void createProduct(Map<String,Object> productinfo);

    Product find_product_by_productid(int productid);

    List<Product> find_all_products();
}
