package com.thoughtworks.ketsu.infrastructure.repositories;

import com.thoughtworks.ketsu.domain.Product.Product;
import com.thoughtworks.ketsu.domain.Product.ProductInterface;
import com.thoughtworks.ketsu.infrastructure.mybatis.mappers.ProductMapper;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;

/**
 * Created by zyongliu on 16/7/29.
 */
public class ProductRepository implements ProductInterface{
    @Inject
    ProductMapper productMapper;

    @Override
    public void createProduct(Map<String, Object> productinfo) {
        productMapper.createProduct(productinfo);
    }

    @Override
    public Product find_product_by_productid(int productid) {
        return productMapper.find_product_by_productid(productid);
    }

    @Override
    public List<Product> find_all_products() {
        return productMapper.find_all_products();
    }
}
