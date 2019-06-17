package com.systemnet.shop.service;


import com.systemnet.shop.entity.Category;
import com.systemnet.shop.entity.Producer;
import com.systemnet.shop.entity.Product;
import com.systemnet.shop.form.SearchForm;

import java.util.List;

public interface ProductService {
    List<Product> listAllProducts(int page, int limit);

    int countAllProducts();

    List<Product> listProductsByCategory(String categoryUrl, int page, int limit);

    int countProductsByCategory(String categoryUrl);

    List<Category> listAllCategotires();

    List<Producer> listAllProducer();

    List<Product> listProductsBySearchForm(SearchForm searchForm, int page, int limit);

    int countProductsBySearchForm(SearchForm searchForm);
}
