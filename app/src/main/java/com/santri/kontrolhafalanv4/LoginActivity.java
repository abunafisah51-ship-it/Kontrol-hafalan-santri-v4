package com.santri.kontrolhafalanv4;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
public class LoginActivity extends AppCompatActivity {
  @Override protected void onCreate(Bundle b) {
    super.onCreate(b);
    setContentView(R.layout.activity_login);
    Spinner sp = findViewById(R.id.spRole);
    String[] roles = {"Admin", "Pentasmi'", "Wali Santri"};
    sp.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, roles));
    EditText etUser = findViewById(R.id.etUser);
    EditText etPass = findViewById(R.id.etPass);
    Button btn = findViewById(R.id.btnLogin);
    btn.setOnClickListener(v -> {
      String user = etUser.getText().toString().trim();
      String role = sp.getSelectedItem().toString();
      if(user.isEmpty()){
        Toast.makeText(this, "Isi Nama / Nomor WA dulu, Abu!", Toast.LENGTH_SHORT).show();
        return;
      }
      Toast.makeText(this, "Selamat datang, " + role + " - " + user, Toast.LENGTH_SHORT).show();
      startActivity(new Intent(LoginActivity.this, MainActivity.class));
      finish();
    });
  }
}
