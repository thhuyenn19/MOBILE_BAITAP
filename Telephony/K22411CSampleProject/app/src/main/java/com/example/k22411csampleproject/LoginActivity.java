package com.example.k22411csampleproject;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.database.sqlite.SQLiteDatabase;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.connectors.EmployeeConnector;
import com.example.connectors.SQLiteConnector;
import com.example.models.Employee;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class LoginActivity extends AppCompatActivity {
    EditText edtUserName;
    TextView txtNetworkType;
    EditText edtPassword;
    CheckBox chkSaveLoginInfo;
    Button btnLogin;
    String DATABASE_NAME="SalesDatabase.sqlite.db";
    private static final String DB_PATH_SUFFIX = "/databases/";
    SQLiteDatabase database=null;
    BroadcastReceiver networkReceiver=null;
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
        processCopy();
        setupBroadcastReceiver();
    }

    private void setupBroadcastReceiver() {
        networkReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(CONNECTIVITY_SERVICE);
                NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

                View rootView = findViewById(R.id.main);

                if (networkInfo != null && networkInfo.isConnected()) {
                    btnLogin.setVisibility(View.VISIBLE);

                    if (networkInfo.getType() == ConnectivityManager.TYPE_WIFI) {
                        txtNetworkType.setText("Connected with WIFI");
                        rootView.setBackgroundColor(getResources().getColor(android.R.color.holo_blue_light));
                    } else if (networkInfo.getType() == ConnectivityManager.TYPE_MOBILE) {
                        txtNetworkType.setText("Connected with Mobile Data");
                        rootView.setBackgroundColor(getResources().getColor(android.R.color.holo_green_light));
                    }

                } else {
                    btnLogin.setVisibility(View.INVISIBLE);
                    txtNetworkType.setText("No internet connection");
                    rootView.setBackgroundColor(getResources().getColor(android.R.color.darker_gray));
                }
            }
        };
    }



    @SuppressLint("WrongViewCast")
    private void addView() {
        edtUserName = findViewById(R.id.edtUserName);
        edtPassword = findViewById(R.id.edtPassword);
        chkSaveLoginInfo = findViewById(R.id.chkSaveLoginInfo);
        btnLogin=findViewById(R.id.btnLogin);
        txtNetworkType= findViewById(R.id.txtNetworkType);
    }

    public void do_login(View view) {
        String usr = edtUserName.getText().toString();
        String pwd = edtPassword.getText().toString();
        EmployeeConnector ec = new EmployeeConnector();
        SQLiteConnector sqLiteConnector = new SQLiteConnector(this);
        sqLiteConnector.openDatabase();
        Employee emp = ec.login(sqLiteConnector.getDatabase(),usr,pwd);
//        /*Employee emp = ec.login(new SQLiteConnector(this).openDatabase(),usr,pwd);*/ Cachs khac
        if (emp != null) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        } else {
            Toast.makeText(this, "Login failed - please check your account again!",
                    Toast.LENGTH_LONG).show();
        }
    }

    public void do_exit(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
        Resources res = getResources();

        builder.setTitle(res.getText(R.string.confirm_exit_title));
        builder.setMessage(res.getText(R.string.confirm_exit_message));
        builder.setIcon(android.R.drawable.ic_dialog_alert);

        builder.setPositiveButton(res.getText(R.string.confirm_exit_yes), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });

        builder.setNegativeButton(res.getText(R.string.confirm_exit_no), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
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

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    doubleBackToExitPressedOnce = false;
                }
            }, DOUBLE_BACK_PRESS_THRESHOLD);

            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
    public void saveLoginInformation()
    {
        SharedPreferences preferences=getSharedPreferences("LOGIN_INFORMATION", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        String usr = edtUserName.getText().toString();
        String pwd = edtPassword.getText().toString();
        boolean isSave= chkSaveLoginInfo.isChecked();
        editor.putString("USERNAME", usr);
        editor.putString("PASSWORD",pwd);
        editor.putBoolean("SAVED", isSave);
        editor.commit();
    }

    protected void onPause() {
        super.onPause();
        saveLoginInformation();
        if(networkReceiver!=null)
        {
            unregisterReceiver(networkReceiver);
        }
    }
    public void restoreLoginInformation()
    {
        SharedPreferences preferences=getSharedPreferences("LOGIN_INFORMATION", MODE_PRIVATE);
        String usr =preferences.getString("USERNAME", "");
        String pwd =preferences.getString("PASSWORD", "");
        boolean isSave=preferences.getBoolean("SAVED", true);
        if(isSave)
        {
            edtUserName.setText(usr);
            edtPassword.setText(pwd);
            chkSaveLoginInfo.setChecked(isSave);
        }
    }
    protected void onResume()
    {
        super.onResume();
        restoreLoginInformation();
        IntentFilter filter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(networkReceiver, filter);
    }
    private void processCopy() {
        //private app
        File dbFile = getDatabasePath(DATABASE_NAME);

        if (!dbFile.exists())
        {
            try
            {
                CopyDataBaseFromAsset();
                Toast.makeText(this, "Copying sucess from Assets folder", Toast.LENGTH_LONG).show();
            }
            catch (Exception e)
            {
                Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show();
            }
        }
    }
    private String getDatabasePath() {
        return getApplicationInfo().dataDir + DB_PATH_SUFFIX+ DATABASE_NAME;
    }
    public void CopyDataBaseFromAsset()
    {
        try {
            InputStream myInput;

            myInput = getAssets().open(DATABASE_NAME);


            // Path to the just created empty db
            String outFileName = getDatabasePath();

            // if the path doesn't exist first, create it
            File f = new File(getApplicationInfo().dataDir + DB_PATH_SUFFIX);
            if (!f.exists())
                f.mkdir();

            // Open the empty db as the output stream
            OutputStream myOutput = new FileOutputStream(outFileName);

            // transfer bytes from the inputfile to the outputfile
            byte[] buffer = new byte[1024];
            int length;
            while ((length = myInput.read(buffer)) > 0) {
                myOutput.write(buffer, 0, length);
            }

            // Close the streams
            myOutput.flush();
            myOutput.close();
            myInput.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
