package com.thanhhuyen.models;

import java.io.Serializable;

public class Product implements Serializable {
    private int ID;
    private String ProductCode;
    private String ProductName;
    private double UnitPrice;
    private String ImageLink;

    // Constructor mặc định
    public Product() {
    }

    // Constructor đầy đủ
    public Product(int ID, String productCode, String productName, double unitPrice, String imageLink) {
        this.ID = ID;
        this.ProductCode = productCode;
        this.ProductName = productName;
        this.UnitPrice = unitPrice;
        this.ImageLink = imageLink;
    }

    // Getter & Setter
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getProductCode() {
        return ProductCode;
    }

    public void setProductCode(String productCode) {
        this.ProductCode = productCode;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        this.ProductName = productName;
    }

    public double getUnitPrice() {
        return UnitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.UnitPrice = unitPrice;
    }

    public String getImageLink() {
        return ImageLink;
    }

    public void setImageLink(String imageLink) {
        this.ImageLink = imageLink;
    }

    @Override
    public String toString() {
        return ID + "\t" + ProductCode + "\t" + ProductName + "\t" + UnitPrice;
    }
}
