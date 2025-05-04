package com.example.k22411cproject28;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    EditText edtCoefficientA;
    EditText edtCoefficientB;
    TextView txtResult;
    Spinner spinnerLanguage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        addViews();
        setupLanguageSpinner();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void addViews() {
        edtCoefficientA = findViewById(R.id.edtCoefficientA);
        edtCoefficientB = findViewById(R.id.edtCoefficientB);
        txtResult = findViewById(R.id.txtResult);
        spinnerLanguage = findViewById(R.id.spinnerLanguage);
    }

    private void setupLanguageSpinner() {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.title_languages, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerLanguage.setAdapter(adapter);

        // Đặt spinner theo ngôn ngữ hiện tại
        String currentLanguage = Locale.getDefault().getLanguage();
        int position = getPositionByLanguageCode(currentLanguage);
        spinnerLanguage.setSelection(position, false); // Không gọi listener khi set ban đầu

        spinnerLanguage.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedLanguage = getLanguageCodeByPosition(position);
                if (!Locale.getDefault().getLanguage().equals(selectedLanguage)) {
                    changeLanguage(selectedLanguage);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Không làm gì
            }
        });
    }

    private int getPositionByLanguageCode(String languageCode) {
        switch (languageCode) {
            case "vi":
                return 1;
            case "fr":
                return 2;
            case "es":
                return 3;
            case "en":
            default:
                return 0;
        }
    }

    private String getLanguageCodeByPosition(int position) {
        switch (position) {
            case 0:
                return "en";
            case 1:
                return "vi";
            case 2:
                return "fr";
            case 3:
                return "es";
            default:
                return "en";
        }
    }

    private void changeLanguage(String languageCode) {
        Locale newLocale = new Locale(languageCode);
        Locale.setDefault(newLocale);
        Configuration config = new Configuration();
        config.setLocale(newLocale);
        Resources resources = getResources();
        resources.updateConfiguration(config, resources.getDisplayMetrics());

        recreate(); // Khởi động lại Activity để áp dụng thay đổi ngôn ngữ
    }

    public void do_solution(View view) {
        String hsa = edtCoefficientA.getText().toString();
        double a = Double.parseDouble(hsa);
        double b = Double.parseDouble(edtCoefficientB.getText().toString());

        if (a == 0 && b == 0) {
            txtResult.setText(getResources().getText(R.string.title_infinition));
        } else if (a == 0) {
            txtResult.setText(getResources().getText(R.string.title_nosolution));
        } else {
            double x = -b / a;
            txtResult.setText("x=" + x);
        }
    }

    public void do_next(View view) {
        edtCoefficientA.setText("");
        edtCoefficientB.setText("");
        txtResult.setText("");
        edtCoefficientA.requestFocus();
    }

    public void do_exit(View view) {
        finish();
    }
}
