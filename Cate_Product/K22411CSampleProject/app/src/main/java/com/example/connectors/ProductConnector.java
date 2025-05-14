package com.example.connectors;

import com.example.models.ListProduct;
import com.example.models.Product;

import java.util.ArrayList;

public class ProductConnector {
    private ListProduct listProduct;

    public ProductConnector() {
        listProduct = new ListProduct();
        listProduct.generate_sample_dataset();
    }

    public ArrayList<Product> get_all_products() {
        if (listProduct == null) {
            listProduct = new ListProduct();
            listProduct.generate_sample_dataset();
        }
        return listProduct.getProducts();
    }

    public ArrayList<Product> get_products_by_category_id(int cate_id) {
        if (listProduct == null) {
            listProduct = new ListProduct();
            listProduct.generate_sample_dataset();
        }
        ArrayList<Product> results = new ArrayList<>();
        for (Product p : listProduct.getProducts()) {
            if (p.getCate_id() == cate_id) {
                results.add(p);
            }
        }
        return results;
    }
}
