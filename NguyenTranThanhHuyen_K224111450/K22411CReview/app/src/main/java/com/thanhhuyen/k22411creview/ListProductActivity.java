package com.thanhhuyen.k22411creview;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.thanhhuyen.adapters.ProductAdapter;
import com.thanhhuyen.models.ListProduct;
import com.thanhhuyen.models.Product;

import java.util.ArrayList;

public class ListProductActivity extends AppCompatActivity {

    ListView lvProduct;
    ArrayList<Product> products;
    ProductAdapter adapter;

    private static final int REQUEST_ADD_PRODUCT = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list_product);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        lvProduct = findViewById(R.id.lvProduct);

        ListProduct list = new ListProduct();
        list.generateSampleProducts();
        products = list.getProducts();

        adapter = new ProductAdapter(this, R.layout.item_list_product, products);
        lvProduct.setAdapter(adapter);

        // Xử lý khi nhấn vào một item trong ListView để xem chi tiết
        lvProduct.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(ListProductActivity.this, AddProductActitivy.class);
            intent.putExtra("product", products.get(position));
            startActivity(intent);
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option_menu_product, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.menu_add_product) {
            Intent intent = new Intent(this, AddProductActitivy.class);
            startActivityForResult(intent, REQUEST_ADD_PRODUCT);
            return true;

        } else if (id == R.id.menu_about) {
            Intent intent = new Intent(this, AboutActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_ADD_PRODUCT && resultCode == RESULT_OK && data != null) {
            Product newProduct = (Product) data.getSerializableExtra("newProduct");
            if (newProduct != null) {
                products.add(newProduct);
                adapter.notifyDataSetChanged();
            }
        }
    }
}
