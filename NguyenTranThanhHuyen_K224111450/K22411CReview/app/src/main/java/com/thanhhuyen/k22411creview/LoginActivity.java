package com.thanhhuyen.k22411creview;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.thanhhuyen.connectors.AccountConnector;
import com.thanhhuyen.models.Account;

public class LoginActivity extends AppCompatActivity {

    EditText edtUserName;
    EditText edtPassword;
    CheckBox chkSaveLoginInfo;

    private boolean doubleBackToExitPressedOnce = false;
    private static final long DOUBLE_BACK_PRESS_THRESHOLD = 1200;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        addView();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void addView() {
        edtUserName = findViewById(R.id.edtUserName);
        edtPassword = findViewById(R.id.edtPassword);
        chkSaveLoginInfo = findViewById(R.id.chkSaveLoginInfo);
    }

    public void do_login(View view) {
        String usr = edtUserName.getText().toString().trim();
        String pwd = edtPassword.getText().toString().trim();

        AccountConnector connector = new AccountConnector();
        Account acc = connector.login(usr, pwd);

        if (acc != null) {
            if (chkSaveLoginInfo.isChecked()) {
                saveLoginInformation(usr, pwd, true);
            } else {
                saveLoginInformation("", "", false);
            }

            Toast.makeText(this, "Login successful", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, ListProductActivity.class); // SCREEN B
            startActivity(intent);
        } else {
            Toast.makeText(this, "Login failed - please check your account!", Toast.LENGTH_LONG).show();
        }
    }

    public void do_exit(View view) {
        finish(); // Không dùng confirm
    }

    private void saveLoginInformation(String username, String password, boolean isSave) {
        SharedPreferences preferences = getSharedPreferences("LOGIN_INFORMATION", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("USERNAME", username);
        editor.putString("PASSWORD", password);
        editor.putBoolean("SAVED", isSave);
        editor.apply();
    }

    private void restoreLoginInformation() {
        SharedPreferences preferences = getSharedPreferences("LOGIN_INFORMATION", MODE_PRIVATE);
        String usr = preferences.getString("USERNAME", "");
        String pwd = preferences.getString("PASSWORD", "");
        boolean isSave = preferences.getBoolean("SAVED", false);
        if (isSave) {
            edtUserName.setText(usr);
            edtPassword.setText(pwd);
            chkSaveLoginInfo.setChecked(true);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        saveLoginInformation(
                edtUserName.getText().toString(),
                edtPassword.getText().toString(),
                chkSaveLoginInfo.isChecked()
        );
    }

    @Override
    protected void onResume() {
        super.onResume();
        restoreLoginInformation();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (doubleBackToExitPressedOnce) {
                finish();
                return true;
            }

            this.doubleBackToExitPressedOnce = true;
            Toast.makeText(this, "Nhấn BACK lần nữa để thoát", Toast.LENGTH_SHORT).show();

            new Handler().postDelayed(() -> doubleBackToExitPressedOnce = false, DOUBLE_BACK_PRESS_THRESHOLD);
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
