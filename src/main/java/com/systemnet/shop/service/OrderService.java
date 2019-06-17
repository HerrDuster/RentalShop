package com.systemnet.shop.service;


import com.systemnet.shop.form.ProductForm;
import com.systemnet.shop.model.ShoppingCart;

public interface OrderService {

    void addProductToShoppingCart(ProductForm productForm, ShoppingCart shoppingCart);
}
