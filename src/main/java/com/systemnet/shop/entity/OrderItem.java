package com.systemnet.shop.entity;

public class OrderItem extends AbstractEntity<Integer> {
    private int idOrder;
    private Product product;
    private int count;

    public OrderItem(int idOrder, Product product, int count) {
        this.idOrder = idOrder;
        this.product = product;
        this.count = count;
    }

    public OrderItem() {
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
