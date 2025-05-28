package com.thanhhuyen.adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.thanhhuyen.k22411creview.R;
import com.thanhhuyen.models.Product;

import java.util.List;

public class ProductAdapter extends ArrayAdapter<Product> {
    private final Activity context;
    private final int resource;
    private final List<Product> productList;

    public ProductAdapter(@NonNull Activity context, int resource, @NonNull List<Product> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.productList = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View item = convertView;
        if (item == null) {
            LayoutInflater inflater = context.getLayoutInflater();
            item = inflater.inflate(resource, parent, false);
        }

        ImageView imgProduct = item.findViewById(R.id.imgProduct);
        TextView txtProductId = item.findViewById(R.id.txtProductId);
        TextView txtProductCode = item.findViewById(R.id.txtProductCode);
        TextView txtProductName = item.findViewById(R.id.txtProductName);
        TextView txtProductPrice = item.findViewById(R.id.txtProductPrice);

        Product p = productList.get(position);
        txtProductId.setText("ID: " + p.getID());
        txtProductCode.setText("Code: " + p.getProductCode());
        txtProductName.setText("Name: " + p.getProductName());
        txtProductPrice.setText("Price: " + p.getUnitPrice() + " VND");

        // Load ảnh từ URL bằng Glide
        Glide.with(context)
                .load(p.getImageLink())
                .into(imgProduct);

        return item;
    }
}
