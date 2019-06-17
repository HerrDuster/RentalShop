package com.systemnet.shop.service.impl;


import com.systemnet.shop.entity.Category;
import com.systemnet.shop.entity.Producer;
import com.systemnet.shop.entity.Product;
import com.systemnet.shop.exception.InternalServerErrorException;
import com.systemnet.shop.form.SearchForm;
import com.systemnet.shop.jdbc.JDBCUtils;
import com.systemnet.shop.jdbc.ResultSetHandler;
import com.systemnet.shop.jdbc.ResultSetHandlerFactory;
import com.systemnet.shop.service.ProductService;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


class ProductServiceImpl implements ProductService {
    private static final ResultSetHandler<List<Product>> productsResultSetHandler = ResultSetHandlerFactory.getListResultSetHandler(ResultSetHandlerFactory.PRODUCT_RESULT_SET_HANDLER);
    private static final ResultSetHandler<List<Category>> categoryResultSetHandler = ResultSetHandlerFactory.getListResultSetHandler(ResultSetHandlerFactory.CATEGORY_RESULT_SET_HANDLER);
    private static final ResultSetHandler<List<Producer>> producerResultSetHandler = ResultSetHandlerFactory.getListResultSetHandler(ResultSetHandlerFactory.PRODUCER_RESULT_SET_HANDLER);
    private static final ResultSetHandler<Integer> countResultSetHandler = ResultSetHandlerFactory.getCountResultSetHandler();

    private final DataSource dataSource;



    ProductServiceImpl(DataSource dataSource) {
        super();
        this.dataSource = dataSource;
    }

    @Override
    public List<Product> listAllProducts(int page, int limit) {
        try (Connection c = dataSource.getConnection()) {
            int offsset = (page - 1) * limit;
            return JDBCUtils.select(c, "SELECT * FROM product A left join category B on (A.id_category=B.id)  left join " +
                    "producer C on (A.id_producer=C.id) limit ? offset ?", productsResultSetHandler, 6, 0);
        } catch (SQLException e) {
            throw new InternalServerErrorException("Can`t execute sql query: " + e.getMessage(), e);
        }
    }

    @Override
    public int countAllProducts() {
        try (Connection c = dataSource.getConnection()) {
            return JDBCUtils.select(c, "SELECT count(*) FROM product", countResultSetHandler);
        } catch (SQLException e) {
            throw new InternalServerErrorException("Can`t execute sql query: " + e.getMessage(), e);
        }
    }

    @Override
    public List<Product> listProductsByCategory(String categoryUrl, int page, int limit) {
        try(Connection c = dataSource.getConnection()) {
            int offsset = (page - 1) * limit;
            return JDBCUtils.select(c, "SELECT * FROM product A left join category B on (A.id_category=B.id) WHERE B.url = ?", productsResultSetHandler, categoryUrl);
        } catch (SQLException e) {
           throw new InternalServerErrorException("Can`t execute sql query: " + e.getMessage(), e);
        }
    }

    @Override
    public int countProductsByCategory(String categoryUrl) {
        try(Connection c = dataSource.getConnection()) {
            return JDBCUtils.select(c, "SELECT count(*) product A left join category B on(A.id_category=B.id) WHERE (B.url ?)",countResultSetHandler, categoryUrl);
        } catch (SQLException e) {
            throw new InternalServerErrorException("Can`t execute sql query: " + e.getMessage(), e);
        }
    }

    @Override
    public List<Category> listAllCategotires() {
        try(Connection c = dataSource.getConnection()){
            return JDBCUtils.select(c, "Select * FROM category order by id",categoryResultSetHandler);
        } catch (SQLException e) {
            throw new InternalServerErrorException("Can`t execute sql query: " + e.getMessage(), e);
        }
    }

    @Override
    public List<Producer> listAllProducer() {
        try(Connection c = dataSource.getConnection()) {
            return JDBCUtils.select(c,"SELECT * FROM producer order by id", producerResultSetHandler);
        } catch (SQLException e) {
            throw new InternalServerErrorException("Can`t execute sql query: " + e.getMessage(), e);
        }
    }

    @Override
    public List<Product> listProductsBySearchForm(SearchForm searchForm, int page, int limit) {
        try (Connection c = dataSource.getConnection()) {
            int offsset = (page - 1) * limit;
            return JDBCUtils.select(c, "SELECT * FROM product A left join category B on (A.id_category=B.id)  left join " +
                    "producer C on (A.id_producer=C.id) WHERE (A.name like ? or A.description like ?)", productsResultSetHandler,"%" + searchForm.getQuery()+"%","%" + searchForm.getQuery()+"%");
        } catch (SQLException e) {
            throw new InternalServerErrorException("Can`t execute sql query: " + e.getMessage(), e);
        }
    }

    @Override
    public int countProductsBySearchForm(SearchForm searchForm) {
        try (Connection c = dataSource.getConnection()) {
            return JDBCUtils.select(c, "SELECT count(*) FROM product A left join category B on (A.id_category=B.id)  left join " +
                    "producer C on (A.id_producer=C.id) WHERE (A.name like ? or A.description like ?)", countResultSetHandler,"%" + searchForm.getQuery()+"%","%" + searchForm.getQuery()+"%");
        } catch (SQLException e) {
            throw new InternalServerErrorException("Can`t execute sql query: " + e.getMessage(), e);
        }
    }
}
