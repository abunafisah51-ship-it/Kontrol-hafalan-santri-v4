package com.santri.kontrolhafalanv4;
import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
public class DetailActivity extends AppCompatActivity {
  @Override protected void onCreate(Bundle b){
    super.onCreate(b);
    setContentView(R.layout.activity_detail);
    String nama = getIntent().getStringExtra("surah_name");
    TextView tv = findViewById(R.id.tvJudulSurah);
    EditText et = findViewById(R.id.etCatatan);
    Button btn = findViewById(R.id.btnSimpan);
    tv.setText(nama);
    android.content.SharedPreferences sp = getSharedPreferences("hafalan", MODE_PRIVATE);
    et.setText(sp.getString(nama, ""));
    btn.setOnClickListener(v -> {
      sp.edit().putString(nama, et.getText().toString()).apply();
      Toast.makeText(this, "Tersimpan!", Toast.LENGTH_SHORT).show();
      finish();
    });
  }
}
