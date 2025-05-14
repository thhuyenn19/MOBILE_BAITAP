package com.example.k22411csampleproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    ImageView imgEmployee;
    TextView txtEmployee;
    ImageView imgCustomer;
    TextView txtCustomer;
    ImageView imgCategory;
    TextView txtCategory;
    ImageView imgProduct;
    TextView txtProduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        addViews();
        addEvents();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void addViews() {
        imgEmployee = findViewById(R.id.imgEmployee);
        txtEmployee = findViewById(R.id.txtEmployee);
        imgCustomer = findViewById(R.id.imgCustomer);
        txtCustomer = findViewById(R.id.txtCustomer);
        imgCategory = findViewById(R.id.imgCategory);
        txtCategory = findViewById(R.id.txtCategory);
        imgProduct = findViewById(R.id.imgProduct);
        txtProduct = findViewById(R.id.txtProduct);
    }

    private void addEvents() {
        imgEmployee.setOnClickListener(v -> openEmployeeManagementActivity());
        txtEmployee.setOnClickListener(v -> openEmployeeManagementActivity());

        imgCustomer.setOnClickListener(v -> openCustomerManagementActivity());
        txtCustomer.setOnClickListener(v -> openCustomerManagementActivity());

        imgCategory.setOnClickListener(v -> openCategoryManagementActivity());
        txtCategory.setOnClickListener(v -> openCategoryManagementActivity());

        imgProduct.setOnClickListener(v -> openProductManagementActivity());
        txtProduct.setOnClickListener(v -> openProductManagementActivity());
    }

    void openEmployeeManagementActivity() {
        Intent intent = new Intent(MainActivity.this, EmployeeManagementActivity.class);
        startActivity(intent);
    }

    void openCustomerManagementActivity() {
        Intent intent = new Intent(MainActivity.this, CustomerManagementActivity.class);
        startActivity(intent);
    }

    void openCategoryManagementActivity() {
        Intent intent = new Intent(MainActivity.this, CategoryManagementActivity.class);
        startActivity(intent);
    }

    void openProductManagementActivity() {
        Intent intent = new Intent(MainActivity.this, ProductManagementActivity.class);
        startActivity(intent);
    }
}
