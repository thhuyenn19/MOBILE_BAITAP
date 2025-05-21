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
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.connectors.CustomerConnector;
import com.example.models.Customer;

public class CustomerManagementActivity extends AppCompatActivity {
    ListView lvCustomer;
    ArrayAdapter<Customer> adapter;
    CustomerConnector connector;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_customer_management);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        addViews();
        addEvents();
    }

    private void addEvents() {
        /*lvCustomer.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Customer selected = adapter.getItem(position);
                adapter.remove(selected);
                return false;
            }
        });*/
        lvCustomer.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Customer c=adapter.getItem(position);
                displayCustomerDetailActivity(c);
            }
        });
    }

    private void displayCustomerDetailActivity(Customer c) {
        Intent intent=new Intent(CustomerManagementActivity.this, CustomerDetailActivity.class);
        intent.putExtra("SELECTED_CUSTOMER", c);
        startActivity(intent);
    }

    private void addViews() {
        lvCustomer=findViewById(R.id.lvCustomer);
        adapter=new ArrayAdapter<>(CustomerManagementActivity.this,
                android.R.layout.simple_list_item_1);
        connector = new CustomerConnector();
        adapter.addAll(connector.get_all_customers());
        lvCustomer.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater =getMenuInflater();
        inflater.inflate(R.menu.option_menu_customer, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==R.id.menu_new_customer)
        {
            Toast.makeText(CustomerManagementActivity.this, "Mo man hinh them moi khach hang", Toast.LENGTH_LONG).show();
            Intent intent=new Intent(CustomerManagementActivity.this, CustomerDetailActivity.class);
            startActivity(intent);
        }
        else if (item.getItemId()==R.id.menu_broadcast_advertising)
        {
            Toast.makeText(CustomerManagementActivity.this, "Gui quang cao hang loat toi khach hang", Toast.LENGTH_LONG).show();
        }
        else if (item.getItemId()==R.id.menu_help)
        {
            Toast.makeText(CustomerManagementActivity.this, "Mo website huong dan su dung", Toast.LENGTH_LONG).show();
        }
        return super.onOptionsItemSelected(item);

    }
}