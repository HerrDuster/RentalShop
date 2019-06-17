package com.systemnet.shop.entity;

public class Category extends AbstractEntity<Integer> {
    private String name;
    private String url;
    private int productCount;

    public Category(String name, String url, int productCount) {
        this.name = name;
        this.url = url;
        this.productCount = productCount;
    }

    public Category() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getProductCount() {
        return productCount;
    }

    public void setProductCount(int productCount) {
        this.productCount = productCount;
    }
}
