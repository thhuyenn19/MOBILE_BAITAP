package com.example.k22411csampleproject;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.adapters.OrderDetailsAdapter;
import com.example.connectors.OrdersViewerConnector;
import com.example.connectors.SQLiteConnector;
import com.example.models.OrderDetailsWithProductName;
import com.example.models.OrdersViewer;

import java.util.List;

public class OrdersDetailActivity extends AppCompatActivity {

    EditText edtOrderId, edtOrderCode, edtOrderDate, edtEmployeeName, edtCustomerName, edtTotalOrderValue;
    RecyclerView rvOrderProducts;
    OrderDetailsAdapter orderDetailsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orders_detail);

        addViews();

        // Thiết lập LayoutManager cho RecyclerView
        rvOrderProducts.setLayoutManager(new LinearLayoutManager(this));

        loadData();
    }

    private void addViews() {
        edtOrderId = findViewById(R.id.edt_order_id);
        edtOrderCode = findViewById(R.id.edt_order_code);
        edtOrderDate = findViewById(R.id.edt_order_date);
        edtEmployeeName = findViewById(R.id.edt_employee_name);
        edtCustomerName = findViewById(R.id.edt_customer_name);
        edtTotalOrderValue = findViewById(R.id.edt_total_order_value);
        rvOrderProducts = findViewById(R.id.rv_order_products);
    }

    private void loadData() {
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("orderViewer")) {
            OrdersViewer ov = (OrdersViewer) intent.getSerializableExtra("orderViewer");

            // Gán thông tin đơn hàng lên EditText
            edtOrderId.setText(String.valueOf(ov.getId()));
            edtOrderCode.setText(ov.getCode());
            edtOrderDate.setText(ov.getOrderDate());
            edtEmployeeName.setText(ov.getEmployeeName());
            edtCustomerName.setText(ov.getCustomerName());
            edtTotalOrderValue.setText(ov.getTotalOrderValue() + " VNĐ");

            // Mở DB bằng SQLiteConnector
            SQLiteConnector sqliteConnector = new SQLiteConnector(this);
            SQLiteDatabase db = sqliteConnector.openDatabase();

            // Lấy chi tiết sản phẩm theo orderId
            OrdersViewerConnector connector = new OrdersViewerConnector();
            List<OrderDetailsWithProductName> detailsList = connector.getOrderDetailsWithProductName(db, ov.getId());

            // Gán adapter RecyclerView
            orderDetailsAdapter = new OrderDetailsAdapter(detailsList);
            rvOrderProducts.setAdapter(orderDetailsAdapter);
        }
    }
}
