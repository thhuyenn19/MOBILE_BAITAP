package com.example.connectors;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.models.PaymentMethod;

import java.util.ArrayList;
import java.util.List;

public class PaymentMethodConnector {

    public List<PaymentMethod> getAllPaymentMethods(SQLiteDatabase database) {
        List<PaymentMethod> paymentMethods = new ArrayList<>();

        // Truy vấn lấy tất cả PaymentMethod từ database
        Cursor cursor = database.rawQuery("SELECT * FROM PaymentMethod", null);

        if (cursor != null && cursor.getCount() > 0) {
            int idColumnIndex = cursor.getColumnIndex("Id");
            int nameColumnIndex = cursor.getColumnIndex("Name");
            int descriptionColumnIndex = cursor.getColumnIndex("Description");

            // Duyệt qua các dòng và thêm vào danh sách PaymentMethod
            while (cursor.moveToNext()) {
                int id = cursor.getInt(idColumnIndex);
                String name = cursor.getString(nameColumnIndex);
                String description = cursor.getString(descriptionColumnIndex);

                PaymentMethod paymentMethod = new PaymentMethod(id, name, description);
                paymentMethods.add(paymentMethod);
            }
            cursor.close();
        }
        return paymentMethods;
    }
}
