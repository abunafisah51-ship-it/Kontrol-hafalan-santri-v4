package com.santri.kontrolhafalanv4;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    EditText etInput;
    TextView tvLabel;
    String peran = "GURU";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button btnGuru = findViewById(R.id.btnGuru);
        Button btnWali = findViewById(R.id.btnWali);
        Button btnMasuk = findViewById(R.id.btnMasuk);
        etInput = findViewById(R.id.etInput);
        tvLabel = findViewById(R.id.tvLabel);
        btnGuru.setOnClickListener(v -> {
            peran = "GURU";
            tvLabel.setText("Masukkan PIN Guru");
            etInput.setHint("PIN Guru - contoh 1234");
            etInput.setText("");
        });
        btnWali.setOnClickListener(v -> {
            peran = "WALI";
            tvLabel.setText("Masukkan Nama Santri");
            etInput.setHint("Nama lengkap santri");
            etInput.setText("");
        });
        btnMasuk.setOnClickListener(v -> {
            String input = etInput.getText().toString().trim();
            if (input.isEmpty()) { Toast.makeText(this, "Diisi dulu ya", Toast.LENGTH_SHORT).show(); return; }
            if (peran.equals("GURU") && !input.equals("1234")) { Toast.makeText(this, "PIN Salah!", Toast.LENGTH_SHORT).show(); return; }
            SharedPreferences pref = getSharedPreferences("BUKOM", MODE_PRIVATE);
            pref.edit().putString("peran", peran).putString("nama", input).apply();
            startActivity(new Intent(this, MainActivity.class));
            finish();
        });
    }
}
