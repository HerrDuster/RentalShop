package com.systemnet.shop.entity;

public class Producer extends AbstractEntity<Integer> {

    private String name;
    private int productCount;

    public Producer(String name, int productCount) {
        this.name = name;
        this.productCount = productCount;
    }

    public Producer() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getProductCount() {
        return productCount;
    }

    public void setProductCount(int productCount) {
        this.productCount = productCount;
    }
}
