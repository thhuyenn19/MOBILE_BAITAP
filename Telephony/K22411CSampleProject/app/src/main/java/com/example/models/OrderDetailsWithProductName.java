package com.example.models;

public class OrderDetailsWithProductName extends OrderDetails {
    private String productName;

    public OrderDetailsWithProductName() {
        super();
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
