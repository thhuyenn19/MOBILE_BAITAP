package com.example.k22411csampleproject;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.adapters.TelephonyInforAdapter;
import com.example.models.TelephonyInfor;

import java.util.ArrayList;

public class TelephonyActivity extends AppCompatActivity {
    ListView lvTelephony;
    TelephonyInforAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_telephony);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        addViews();
        getAllContacts();
        addEvents();
    }

    private void addViews() {
        lvTelephony = findViewById(R.id.lvTelephonyInfor);
        ArrayList<TelephonyInfor> telephonyList = new ArrayList<>();
        adapter = new TelephonyInforAdapter(this, R.layout.item_telephony_infor, telephonyList);
        lvTelephony.setAdapter(adapter);
    }

    private void addEvents() {
        lvTelephony.setOnItemClickListener((parent, view, position, id) -> {
            TelephonyInfor ti = adapter.getItem(position);
            makeAPhoneCall(ti);
        });
    }

    private void makeAPhoneCall(TelephonyInfor ti) {
        Uri uri = Uri.parse("tel:" + ti.getPhone());
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(uri);
        startActivity(intent);
    }

    private void getAllContacts() {
        Uri uri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
        String[] projection = {
                ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
                ContactsContract.CommonDataKinds.Phone.NUMBER
        };

        Cursor cursor = getContentResolver().query(uri, projection, null, null, null);
        if (cursor != null) {
            adapter.clear();
            while (cursor.moveToNext()) {
                String name = cursor.getString(cursor.getColumnIndexOrThrow(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
                String phone = cursor.getString(cursor.getColumnIndexOrThrow(ContactsContract.CommonDataKinds.Phone.NUMBER));

                TelephonyInfor ti = new TelephonyInfor();
                ti.setName(name);
                ti.setPhone(phone);
                ti.setCarrier(getCarrier(phone));
                adapter.add(ti);
            }
            cursor.close();
        }
    }

    private String getCarrier(String phoneNumber) {
        phoneNumber = phoneNumber.replace(" ", "").replace("+84", "0");

        if (phoneNumber.startsWith("086") || phoneNumber.startsWith("096") ||
                phoneNumber.startsWith("097") || phoneNumber.startsWith("098") ||
                phoneNumber.startsWith("032") || phoneNumber.startsWith("033") ||
                phoneNumber.startsWith("034") || phoneNumber.startsWith("035") ||
                phoneNumber.startsWith("036") || phoneNumber.startsWith("037") ||
                phoneNumber.startsWith("038") || phoneNumber.startsWith("039")) {
            return "Viettel";
        }

        if (phoneNumber.startsWith("090") || phoneNumber.startsWith("093") ||
                phoneNumber.startsWith("089") || phoneNumber.startsWith("070") ||
                phoneNumber.startsWith("079") || phoneNumber.startsWith("077") ||
                phoneNumber.startsWith("076") || phoneNumber.startsWith("078")) {
            return "Mobifone";
        }

        return "Khác";
    }

    private void filterContactsByCarrier(String carrier) {
        Uri uri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
        String[] projection = {
                ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
                ContactsContract.CommonDataKinds.Phone.NUMBER
        };

        Cursor cursor = getContentResolver().query(uri, projection, null, null, null);
        if (cursor != null) {
            adapter.clear();
            while (cursor.moveToNext()) {
                String name = cursor.getString(cursor.getColumnIndexOrThrow(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
                String phone = cursor.getString(cursor.getColumnIndexOrThrow(ContactsContract.CommonDataKinds.Phone.NUMBER));

                if (getCarrier(phone).equals(carrier)) {
                    TelephonyInfor ti = new TelephonyInfor();
                    ti.setName(name);
                    ti.setPhone(phone);
                    ti.setCarrier(carrier);
                    adapter.add(ti);
                }
            }
            cursor.close();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.telephony_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.mnuViettel) {
            filterContactsByCarrier("Viettel");
            return true;
        } else if (id == R.id.mnuMobifone) {
            filterContactsByCarrier("Mobifone");
            return true;
        } else if (id == R.id.mnuOther) {
            filterContactsByCarrier("Khác");
            return true;
        } else if (id == R.id.mnuAll) {
            getAllContacts();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void directCall(TelephonyInfor ti) {
        Uri uri = Uri.parse("tel:" + ti.getPhone());
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(uri);
        startActivity(intent);
    }

    public void dialupCall(TelephonyInfor ti) {
        Uri uri = Uri.parse("tel:" + ti.getPhone());
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(uri);
        startActivity(intent);
    }

    public void se(TelephonyInfor ti) {
        Uri uri = Uri.parse("tel:" + ti.getPhone());
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(uri);
        startActivity(intent);
    }
}
