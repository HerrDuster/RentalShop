package com.systemnet.shop.form;

import lombok.Data;

@Data
public class ProductForm {

    private Integer idProduct;
    private Integer count;

    public ProductForm(Integer idProduct, Integer count) {
        this.idProduct = idProduct;
        this.count = count;
    }
}
