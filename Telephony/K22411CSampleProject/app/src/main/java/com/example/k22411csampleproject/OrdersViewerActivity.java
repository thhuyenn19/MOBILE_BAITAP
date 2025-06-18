package com.example.k22411csampleproject;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.adapters.OrdersViewerAdapter;
import com.example.connectors.OrdersViewerConnector;
import com.example.connectors.SQLiteConnector;
import com.example.models.OrdersViewer;

import java.util.ArrayList;

public class OrdersViewerActivity extends AppCompatActivity {
    ListView lvOrdersViewer;
    ArrayAdapter<OrdersViewer> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_orders_viewer);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        addViews();
    }

    private void addViews() {
        lvOrdersViewer = findViewById(R.id.lvOrdersViewer);
        adapter = new OrdersViewerAdapter(this, R.layout.item_ordersviewer);
        lvOrdersViewer.setAdapter(adapter);

        SQLiteConnector connector = new SQLiteConnector(this);
        OrdersViewerConnector ovc = new OrdersViewerConnector();
        ArrayList<OrdersViewer> dataset = ovc.getAllOrdersViewers(connector.openDatabase());
        adapter.addAll(dataset);

        // Đặt lắng nghe sự kiện click vào trong addViews()
        lvOrdersViewer.setOnItemClickListener((parent, view, position, id) -> {
            OrdersViewer selectedOrder = adapter.getItem(position);
            Intent intent = new Intent(this, OrdersDetailActivity.class);
            intent.putExtra("orderViewer", selectedOrder);
            startActivity(intent);
        });
    }
}
