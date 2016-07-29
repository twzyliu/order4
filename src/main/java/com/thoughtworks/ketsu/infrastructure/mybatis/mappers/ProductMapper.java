package com.thoughtworks.ketsu.infrastructure.mybatis.mappers;

import com.thoughtworks.ketsu.domain.Product.Product;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by zyongliu on 16/7/29.
 */
public interface ProductMapper {
    void createProduct(@Param("info") Map<String,Object> productinfo);

    Product find_product_by_productid(@Param("id") int productid);

    List<Product> find_all_products();

}
