package com.systemnet.shop.service.impl;

import com.systemnet.shop.entity.Product;
import com.systemnet.shop.exception.InternalServerErrorException;
import com.systemnet.shop.form.ProductForm;
import com.systemnet.shop.jdbc.JDBCUtils;
import com.systemnet.shop.jdbc.ResultSetHandler;
import com.systemnet.shop.jdbc.ResultSetHandlerFactory;
import com.systemnet.shop.model.ShoppingCart;
import com.systemnet.shop.service.OrderService;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


class OrderServiceImpl implements OrderService {
    private static final ResultSetHandler<Product> productResultSetHandler =
            ResultSetHandlerFactory.getSingleResultSetHandler(
                    ResultSetHandlerFactory.PRODUCT_RESULT_SET_HANDLER);

    private final DataSource dataSource;

    public OrderServiceImpl(DataSource dataSource){
        this.dataSource = dataSource;
    }


    @Override
    public void addProductToShoppingCart(ProductForm productForm, ShoppingCart shoppingCart) {
        try (Connection c = dataSource.getConnection()) {
            Product product = JDBCUtils.select(c, "SELECT * FROM product A left join category B on (A.id_category=B.id)  left join " +
                    "producer C on (A.id_producer=C.id) where product.id = ?",
                    productResultSetHandler, productForm.getIdProduct());
            if(product==null){
                throw new InternalServerErrorException("Product don`t found by Id" + productForm.getIdProduct());
            }
            shoppingCart.addProduct(product, productForm.getCount());
        } catch (SQLException e) {
            throw new InternalServerErrorException("Can`t execute sql query: " + e.getMessage(), e);
        }
    }
}
