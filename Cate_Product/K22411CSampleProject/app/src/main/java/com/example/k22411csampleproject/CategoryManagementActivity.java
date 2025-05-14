package com.example.k22411csampleproject;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.connectors.CatalogConnector;
import com.example.models.Catalog;

public class CategoryManagementActivity extends AppCompatActivity {
    ListView lvCatalog;
    ArrayAdapter<Catalog> adapter;
    CatalogConnector connector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_category_management);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        addViews();
        addEvents();
    }

    private void addViews() {
        lvCatalog = findViewById(R.id.lvCatalog);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
        connector = new CatalogConnector();
        adapter.addAll(connector.get_all_catalogs());
        lvCatalog.setAdapter(adapter);
    }

    private void addEvents() {
        lvCatalog.setOnItemLongClickListener((parent, view, position, id) -> {
            Catalog selected = adapter.getItem(position);
            adapter.remove(selected);
            return false;
        });
    }
}
