package com.example.models;

public class PaymentMethod {
    private int id;        // Sử dụng 'id' thay vì 'Id' để tuân thủ quy ước đặt tên Java
    private String name;
    private String description;

    // Constructor mặc định
    public PaymentMethod() {
    }

    // Constructor với các tham số
    public PaymentMethod(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    // Getter và Setter cho các thuộc tính

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
