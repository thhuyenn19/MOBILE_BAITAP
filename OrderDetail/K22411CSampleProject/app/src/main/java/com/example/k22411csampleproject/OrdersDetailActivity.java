package com.example.k22411csampleproject;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.models.OrdersViewer;

public class OrdersDetailActivity extends AppCompatActivity {

    EditText edtOrderId, edtOrderCode, edtOrderDate, edtEmployeeName, edtCustomerName, edtTotalOrderValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orders_detail);

        addViews();
        showData();
    }

    private void addViews() {
        edtOrderId = findViewById(R.id.edt_order_id);
        edtOrderCode = findViewById(R.id.edt_order_code);
        edtOrderDate = findViewById(R.id.edt_order_date);
        edtEmployeeName = findViewById(R.id.edt_employee_name);
        edtCustomerName = findViewById(R.id.edt_customer_name);
        edtTotalOrderValue = findViewById(R.id.edt_total_order_value);
    }

    private void showData() {
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("orderViewer")) {
            OrdersViewer ov = (OrdersViewer) intent.getSerializableExtra("orderViewer");

            edtOrderId.setText(String.valueOf(ov.getId()));
            edtOrderCode.setText(ov.getCode());
            edtOrderDate.setText(ov.getOrderDate());
            edtEmployeeName.setText(ov.getEmployeeName());
            edtCustomerName.setText(ov.getCustomerName());
            edtTotalOrderValue.setText(ov.getTotalOrderValue() + " VNĐ");

        }
    }
}
