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

    ImageView imgProduct;
    TextView txtProduct;
    ImageView imgAdvancedProduct;
    TextView txtAdvancedProduct;
    ImageView imgPaymentMethod;
    TextView txtPaymentMethod;
    ImageView imgOrders;
    TextView txtOrders;
    ImageView imgTelephony;
    TextView txtTelephony;


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

        imgProduct = findViewById(R.id.imgProduct);
        txtProduct = findViewById(R.id.txtProduct);
        imgAdvancedProduct = findViewById(R.id.imgAdvancedProduct);
        txtAdvancedProduct = findViewById(R.id.txtAdvancedProduct);
        imgPaymentMethod = findViewById(R.id.imgPaymentMethod);
        txtPaymentMethod = findViewById(R.id.txtPaymentMethod);
        imgOrders = findViewById(R.id.imgOrders);
        txtOrders = findViewById(R.id.txtOrders);
        imgTelephony = findViewById(R.id.imgTelephony);
        txtTelephony = findViewById(R.id.txtTelephony);
    }

    private void addEvents() {
        imgEmployee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //gọi code mở màn hình quản trị nhân sự
                openEmployeeManagementActivity();
            }
        });
        txtEmployee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //gọi code mở màn hình quản trị nhân sự
                openEmployeeManagementActivity();
            }
        });
        imgCustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCustomerManagementActivity();
            }
        });
        txtCustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCustomerManagementActivity();
            }
        });
        imgProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openProductManagementActivity();
            }
        });
        txtProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openProductManagementActivity();
            }
        });
        imgAdvancedProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAdvancedProductManagementActivity();
            }
        });
        txtAdvancedProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAdvancedProductManagementActivity();
            }
        });
        imgPaymentMethod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPaymentMethodActivity();
            }
        });
        txtPaymentMethod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPaymentMethodActivity();
            }
        });
        imgOrders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openOrdersViewerActivity();
            }
        });
        txtOrders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openOrdersViewerActivity();
            }
        });
        imgTelephony.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTelephonyActivity();
            }
        });
        txtTelephony.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTelephonyActivity();
            }
        });

    }



    void openEmployeeManagementActivity() {
        Intent intent = new Intent(MainActivity.this, EmployeeManagementActivity.class);
        startActivity(intent);
    }

    void openCustomerManagementActivity() {
        Intent intent = new Intent(MainActivity.this, CustomerManagementActivity.class);
        startActivity(intent);
    }

    void openProductManagementActivity() {
        Intent intent = new Intent(MainActivity.this, ProductManagementActivity.class);
        startActivity(intent);
    }
    void openAdvancedProductManagementActivity() {
    Intent intent = new Intent(MainActivity.this, AdvancedProductManagementActivity.class);
        startActivity(intent);
    }
    void openPaymentMethodActivity() {
        Intent intent = new Intent(MainActivity.this, PaymentMethodActivity.class);
        startActivity(intent);
    }
    void openOrdersViewerActivity() {
        Intent intent = new Intent(MainActivity.this, OrdersViewerActivity.class);
        startActivity(intent);
    }
    void openTelephonyActivity() {
        Intent intent = new Intent(MainActivity.this, TelephonyActivity.class);
        startActivity(intent);
    }

}
