package com.example.k22411csampleproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.models.Customer;

public class CustomerDetailActivity extends AppCompatActivity {
    EditText edt_customer_id;
    EditText edt_customer_name;
    EditText edt_customer_email;
    EditText edt_customer_phone;
    EditText edt_customer_username;
    EditText edt_customer_password;
    Button btnNew;
    Button btnSave;
    Button btnRemove;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_customer_detail);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

        });
        addViews();
        addEvents();

    }

    private void addEvents() {
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process_save_customer();
            }

        });
        btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process_remove_customer();
            }
        });
    }

    private void process_remove_customer() {
            Intent intent = getIntent();
            String id = edt_customer_id.getText().toString();
            intent.putExtra("CUSTOMER_ID_REMOVE", id);
            setResult(600,intent );
            finish();
    }

    private void process_save_customer() {
        //Lấy dữ liệu trên giao diện và mô hình hóa lại hướng đối tượng Customer:
        Customer c =new Customer();
        String id = edt_customer_id.getText().toString();
        if (id.trim().length()>0)
            c.setId(Integer.parseInt(id));
        c.setId(Integer.parseInt(edt_customer_id.getText().toString()));
        c.setName(edt_customer_name.getText().toString());
        c.setEmail(edt_customer_email.getText().toString());
        c.setPhone(edt_customer_phone.getText().toString());
        c.setUsername(edt_customer_username.getText().toString());
        c.setPassword(edt_customer_password.getText().toString());

        //Lấy intent từ màn hình gọi nó:
        Intent intent = getIntent();
        //đóng gói dữ liệu vào intent:
        intent.putExtra("NEW_CUSTOMER",c);
        //đóng dấu là sẽ gửi gói hàng này đi:
        setResult(500, intent);
        //đóng màn hình này lại, để màn hình gọi nó nhận được kết quả:
        finish();

    }

    private void addViews() {
        edt_customer_id=findViewById(R.id.edt_customer_id);
        edt_customer_name=findViewById(R.id.edt_customer_name);
        edt_customer_email=findViewById(R.id.edt_customer_email);
        edt_customer_phone=findViewById(R.id.edt_customer_phone);
        edt_customer_username=findViewById(R.id.edt_customer_username);
        edt_customer_password=findViewById(R.id.edt_customer_password);
        display_infor();

        btnNew=findViewById(R.id.btnNew);
        btnSave=findViewById(R.id.btnSave);
        btnRemove=findViewById(R.id.btnRemove);
    }

    private void display_infor() {
        //Lấy intent từ bên CustomerManagementAct gửi qua:
        Intent intent=getIntent();
        //Lấy dữ liệu Selected Customer từ intent:
        Customer c= (Customer) intent.getSerializableExtra("SELECTED_CUSTOMER");
        if (c==null)
        {
            edt_customer_id.setVisibility(View.GONE);
            return;
        }
        //Hiển thị thông tin Customer lên giao diện:
        edt_customer_id.setText(c.getId()+"");
        edt_customer_name.setText(c.getName());
        edt_customer_email.setText(c.getEmail());
        edt_customer_phone.setText(c.getPhone());
        edt_customer_username.setText(c.getUsername());
        edt_customer_password.setText(c.getPassword());

    }
}