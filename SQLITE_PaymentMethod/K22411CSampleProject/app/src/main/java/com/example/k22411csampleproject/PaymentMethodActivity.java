package com.example.k22411csampleproject;

import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.adapters.PaymentMethodAdapter;
import com.example.connectors.PaymentMethodConnector;
import com.example.connectors.SQLiteConnector;
import com.example.models.PaymentMethod;

import java.util.List;

public class PaymentMethodActivity extends AppCompatActivity {
    ListView lvPaymentMethod;
    PaymentMethodAdapter adapter;
    PaymentMethodConnector connector;
    SQLiteConnector sqLiteConnector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_payment_method);

        // Apply padding for system bars (status bar, navigation bar)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Initialize views and connectors
        sqLiteConnector = new SQLiteConnector(this);
        connector = new PaymentMethodConnector();

        // Get payment methods from the database
        addViews();
    }

    private void addViews() {
        lvPaymentMethod = findViewById(R.id.lvPaymentMethod);

        // Open database and get payment methods
        List<PaymentMethod> paymentMethods = connector.getAllPaymentMethods(sqLiteConnector.openDatabase());

        // Create and set the adapter for the ListView
        adapter = new PaymentMethodAdapter(PaymentMethodActivity.this, R.layout.item_paymentmethod);
        adapter.addAll(paymentMethods);
        lvPaymentMethod.setAdapter(adapter);
    }
}
