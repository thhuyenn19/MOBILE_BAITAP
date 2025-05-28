package com.thanhhuyen.k22411creview;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.thanhhuyen.models.Product;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class AddProductActitivy extends AppCompatActivity {

    EditText edtId, edtCode, edtName, edtPrice;
    ImageView imgProduct;
    Button btnSave;
    boolean isAddMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product_actitivy);

        // Ánh xạ view
        edtId = findViewById(R.id.edtProductId);
        edtCode = findViewById(R.id.edtProductCode);
        edtName = findViewById(R.id.edtProductName);
        edtPrice = findViewById(R.id.edtProductPrice);
        imgProduct = findViewById(R.id.imgProduct);
        btnSave = findViewById(R.id.btnSave);

        Intent intent = getIntent();
        Product product = (Product) intent.getSerializableExtra("product");

        if (product != null) {
            // 👉 CHẾ ĐỘ XEM CHI TIẾT
            isAddMode = false;

            edtId.setText(String.valueOf(product.getID()));
            edtCode.setText(product.getProductCode());
            edtName.setText(product.getProductName());
            edtPrice.setText(String.valueOf(product.getUnitPrice()));

            // Khóa không cho chỉnh sửa
            edtId.setEnabled(false);
            edtCode.setEnabled(false);
            edtName.setEnabled(false);
            edtPrice.setEnabled(false);

            btnSave.setVisibility(View.GONE);

            // Hiện ảnh nếu có link
            if (product.getImageLink() != null && !product.getImageLink().isEmpty()) {
                imgProduct.setVisibility(View.VISIBLE);
                new DownloadImageTask(imgProduct).execute(product.getImageLink());
            } else {
                imgProduct.setVisibility(View.GONE);
            }

        } else {
            // 👉 CHẾ ĐỘ THÊM MỚI
            isAddMode = true;
            imgProduct.setVisibility(View.GONE); // Ẩn ảnh
            btnSave.setVisibility(View.VISIBLE);

            btnSave.setOnClickListener(v -> {
                try {
                    int id = Integer.parseInt(edtId.getText().toString());
                    String code = edtCode.getText().toString();
                    String name = edtName.getText().toString();
                    double price = Double.parseDouble(edtPrice.getText().toString());

                    Product newProduct = new Product(id, code, name, price, "");
                    Intent result = new Intent();
                    result.putExtra("newProduct", newProduct);
                    setResult(RESULT_OK, result);
                    finish();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
    }

    // Tải ảnh từ internet
    private static class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        ImageView imageView;

        public DownloadImageTask(ImageView imageView) {
            this.imageView = imageView;
        }

        @Override
        protected Bitmap doInBackground(String... urls) {
            try {
                URL url = new URL(urls[0]);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setDoInput(true);
                connection.connect();
                InputStream input = connection.getInputStream();
                return BitmapFactory.decodeStream(input);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            if (bitmap != null) {
                imageView.setImageBitmap(bitmap);
            }
        }
    }
}
