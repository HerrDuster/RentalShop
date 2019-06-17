package com.systemnet.shop.jdbc;

import com.systemnet.shop.entity.Category;
import com.systemnet.shop.entity.Producer;
import com.systemnet.shop.entity.Product;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ResultSetHandlerFactory {

    public final static ResultSetHandler<Product> PRODUCT_RESULT_SET_HANDLER = rs -> {
        Product product = new Product();
        product.setId(rs.getInt("id"));
        product.setName(rs.getString("name"));
        product.setDescription(rs.getString("description"));
        product.setImageLink(rs.getString("image_link"));
        product.setPrice(rs.getBigDecimal("price"));
        product.setStatus(rs.getBoolean("status"));
//        product.setCategory(rs.getString("B.name"));
//        product.setProducer(rs.getString("C.name"));
        return product;
    };

    public final static ResultSetHandler<Integer> getCountResultSetHandler(){
        return rs -> {
            if (rs.next()){
                return rs.getInt(1);
            }else {
                return 0;
            }
        };
    }

    public final static ResultSetHandler<Category> CATEGORY_RESULT_SET_HANDLER=rs -> {
        Category category = new Category();
        category.setName(rs.getString("name"));
        category.setUrl(rs.getString("url"));
        category.setProductCount(rs.getInt("product_count"));
        return category;
    };

    public static final ResultSetHandler<Producer> PRODUCER_RESULT_SET_HANDLER = rs -> {
        Producer producer = new Producer();
        producer.setName(rs.getString("name"));
        producer.setProductCount(rs.getInt("product_count"));
        return producer;
    };

    public final static <T> ResultSetHandler<T> getSingleResultSetHandler(final ResultSetHandler<T> oneRowResultHandler) {
        return rs -> {
            if (rs.next()) {
                return oneRowResultHandler.handle(rs);
            } else {
                return null;
            }
        };
    }

    public final static <T> ResultSetHandler<List<T>> getListResultSetHandler(final ResultSetHandler<T> oneRowResultHandler) {
        return rs -> {
            List<T> list = new ArrayList<>();
            while (rs.next()) {
                list.add(oneRowResultHandler.handle(rs));
            }
            return list;
        };
    }

    private ResultSetHandlerFactory(){

    }

}
