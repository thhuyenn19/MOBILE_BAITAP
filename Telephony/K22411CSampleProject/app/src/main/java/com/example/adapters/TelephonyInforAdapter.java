package com.example.adapters;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.k22411csampleproject.R;
import com.example.k22411csampleproject.SendSMSActivity;
import com.example.k22411csampleproject.TelephonyActivity;
import com.example.models.TelephonyInfor;

import java.util.List;

public class TelephonyInforAdapter extends ArrayAdapter<TelephonyInfor> {
    Activity context;
    int resource;

    public TelephonyInforAdapter(@NonNull Activity context, int resource, @NonNull List<TelephonyInfor> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = this.context.getLayoutInflater();
        View item = inflater.inflate(this.resource, null);

        // Ánh xạ các thành phần giao diện
        TextView txtTelephonyName = item.findViewById(R.id.txtTelephonyName);
        TextView txtTelephonyNumber = item.findViewById(R.id.txtTelephonyNumber);
        TextView txtCarrier = item.findViewById(R.id.txtCarrier); // thêm dòng này

        ImageView imgDirectCall = item.findViewById(R.id.imgDirectCall);
        ImageView imgDialUp = item.findViewById(R.id.imgDialUp);
        ImageView imgSendSms = item.findViewById(R.id.imgSendSms);

        // Lấy thông tin
        TelephonyInfor ti = getItem(position);
        if (ti != null) {
            txtTelephonyName.setText(ti.getName());
            txtTelephonyNumber.setText(ti.getPhone());
            txtCarrier.setText("Nhà mạng: " + ti.getCarrier()); // hiển thị carrier

            imgDirectCall.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ((TelephonyActivity) context).directCall(ti);
                }
            });

            imgDialUp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ((TelephonyActivity) context).dialupCall(ti);
                }
            });

            imgSendSms.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, SendSMSActivity.class);
                    intent.putExtra("TI", ti);
                    context.startActivity(intent);
                }
            });
        }

        return item;
    }
}
