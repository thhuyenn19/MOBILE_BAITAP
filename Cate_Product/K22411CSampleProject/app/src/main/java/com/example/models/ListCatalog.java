package com.example.models;

import java.io.Serializable;
import java.util.ArrayList;

public class ListCatalog implements Serializable {
    private ArrayList<Catalog> catalogs;

    public ListCatalog() {
        catalogs = new ArrayList<>();
    }

    public ArrayList<Catalog> getCatalogs() {
        return catalogs;
    }

    public void setCatalogs(ArrayList<Catalog> catalogs) {
        this.catalogs = catalogs;
    }

    public void addCatalog(Catalog c) {
        catalogs.add(c);
    }

    public void generate_sample_dataset() {
        catalogs.clear();
        catalogs.add(new Catalog(1, "Đồ uống"));
        catalogs.add(new Catalog(2, "Đồ ăn"));
        catalogs.add(new Catalog(3, "Bánh ngọt"));
        catalogs.add(new Catalog(4, "Tráng miệng"));
        catalogs.add(new Catalog(5, "Combo"));
    }
}
