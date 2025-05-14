package com.example.connectors;

import com.example.models.Catalog;
import com.example.models.ListCatalog;

import java.util.ArrayList;

public class CatalogConnector {
    private ListCatalog listCatalog;

    public CatalogConnector() {
        listCatalog = new ListCatalog();
        listCatalog.generate_sample_dataset();
    }

    public ArrayList<Catalog> get_all_catalogs() {
        if (listCatalog == null) {
            listCatalog = new ListCatalog();
            listCatalog.generate_sample_dataset();
        }
        return listCatalog.getCatalogs();
    }

    public Catalog get_catalog_by_id(int id) {
        if (listCatalog == null) {
            listCatalog = new ListCatalog();
            listCatalog.generate_sample_dataset();
        }
        for (Catalog c : listCatalog.getCatalogs()) {
            if (c.getId() == id) {
                return c;
            }
        }
        return null;
    }
}
