package com.example.models;

import java.io.Serializable;

public class Product implements Serializable {
    private int id;
    private String name;
    private int quantity;
    private double price;
    private int cate_id;
    private String description;

    public Product() {
    }

    public Product(int id, String name, int quantity, double price, int cate_id, String description) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.cate_id = cate_id;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCate_id() {
        return cate_id;
    }

    public void setCate_id(int cate_id) {
        this.cate_id = cate_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // Optional: dùng để hiển thị trong ListView nếu bạn dùng ArrayAdapter mặc định
    @Override
    public String toString() {
        return "ID: " + id +
                " | Tên: " + name +
                " | SL: " + quantity +
                " | Giá: " + price +
                " | Danh mục: " + cate_id +
                "\nMô tả: " + description;
    }
}
