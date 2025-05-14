package com.example.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

public class ListProduct implements Serializable {
    private ArrayList<Product> products;

    public ListProduct() {
        products = new ArrayList<>();
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public void addProduct(Product p) {
        products.add(p);
    }

    public void generate_sample_dataset() {
        Random random = new Random();
        products.clear();
        for (int i = 1; i <= 100; i++) {
            int id = i;
            String name = "Product " + i;
            int quantity = random.nextInt(50) + 1;
            double price = 10000 + random.nextInt(90000); // 10k - 100k
            int cate_id = random.nextInt(5) + 1; // giả định có 5 danh mục
            String description = "Mô tả sản phẩm số " + i;

            Product p = new Product(id, name, quantity, price, cate_id, description);
            addProduct(p);
        }
    }
}
