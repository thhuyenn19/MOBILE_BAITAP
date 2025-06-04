package com.example.k22411csampleproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.models.Category;
import com.example.models.ListCategory;
import com.example.models.Product;

public class ProductManagementActivity extends AppCompatActivity {

    Spinner spinnerCategory;
    ListView lvProduct;
    ArrayAdapter<Category> adapterCategory;
    ListCategory listCategory;
    ArrayAdapter<Product> adapterProduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_product_management);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        addViews();
        addEvents();
    }

    private void addViews() {
        spinnerCategory = findViewById(R.id.spinnerCategory);
        adapterCategory = new ArrayAdapter<>(
                ProductManagementActivity.this, android.R.layout.simple_spinner_item);
        adapterCategory.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCategory.setAdapter(adapterCategory);

        listCategory = new ListCategory();
        listCategory.generate_sample_product_dataset();
        adapterCategory.addAll(listCategory.getCatagories());

        lvProduct = findViewById(R.id.lvProduct);
        adapterProduct = new ArrayAdapter<>(
                ProductManagementActivity.this, android.R.layout.simple_list_item_1);
        lvProduct.setAdapter(adapterProduct);
    }

    private void addEvents() {
        spinnerCategory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Category c = adapterCategory.getItem(position);
                displayProductsByCategory(c);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        lvProduct.setOnItemClickListener((parent, view, position, id) -> {
            Product selectedProduct = adapterProduct.getItem(position);
            displayProductDetailActivity(selectedProduct);
        });
    }

    private void displayProductsByCategory(Category c) {
        adapterProduct.clear();
        adapterProduct.addAll(c.getProducts());
    }

    private void displayProductDetailActivity(Product product) {
        Intent intent = new Intent(ProductManagementActivity.this, ProductDetailActivity.class);
        intent.putExtra("SELECTED_PRODUCT", product);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option_menu_product, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.menu_new_product) {
            Toast.makeText(this, "Mở màn hình thêm mới sản phẩm", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(ProductManagementActivity.this, ProductDetailActivity.class);
            startActivity(intent);
        } else if (item.getItemId() == R.id.menu_report) {
            Toast.makeText(this, "Mở màn hình báo cáo sản phẩm", Toast.LENGTH_LONG).show();
            // Có thể chuyển sang ReportActivity nếu bạn tạo:
            // startActivity(new Intent(this, ProductReportActivity.class));
        } else if (item.getItemId() == R.id.menu_help) {
            Toast.makeText(this, "Mở website hướng dẫn sử dụng", Toast.LENGTH_LONG).show();
        }
        return super.onOptionsItemSelected(item);
    }
}
