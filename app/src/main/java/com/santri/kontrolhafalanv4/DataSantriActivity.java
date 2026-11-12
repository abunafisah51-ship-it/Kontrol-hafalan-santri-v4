package com.santri.kontrolhafalanv4;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.HashSet;
public class DataSantriActivity extends AppCompatActivity {
  ArrayList<String> list = new ArrayList<>();
  ArrayAdapter<String> adapter;
  SharedPreferences pref;
  @Override protected void onCreate(Bundle b) {
    super.onCreate(b);
    setContentView(R.layout.activity_data_santri);
    pref = getSharedPreferences("bukom", MODE_PRIVATE);
    list.addAll(pref.getStringSet("santri", new HashSet<>()));
    ListView lv = findViewById(R.id.lvSantri);
    adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);
    lv.setAdapter(adapter);
    Spinner spKelas = findViewById(R.id.spKelas);
    spKelas.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, new String[]{"Kelas 1", "Kelas 2", "Kelas 3"}));
    EditText etNama = findViewById(R.id.etNamaSantri);
    EditText etPentasmi = findViewById(R.id.etPentasmi);
    EditText etWa = findViewById(R.id.etWaWali);
    EditText etJuz = findViewById(R.id.etJuz);
    EditText etHal = findViewById(R.id.etHalaman);
    Button btn = findViewById(R.id.btnTambah);
    btn.setOnClickListener(v -> {
      String nama = etNama.getText().toString().trim();
      String pentasmi = etPentasmi.getText().toString().trim();
      String wa = etWa.getText().toString().trim();
      String kelas = spKelas.getSelectedItem().toString();
      String juz = etJuz.getText().toString().trim();
      String hal = etHal.getText().toString().trim();
      if(juz.isEmpty()) juz = "0";
      if(hal.isEmpty()) hal = "0";
      if(nama.isEmpty() || wa.isEmpty()){
        Toast.makeText(this, "Nama & WA Wali wajib diisi, Abu!", Toast.LENGTH_SHORT).show();
        return;
      }
      String data = "Nama: " + nama + "\nKelas: " + kelas + " | Hafalan: " + juz + " Juz - " + hal + " Halaman\nPentasmi': " + pentasmi + " | WA: " + wa;
      list.add(data);
      adapter.notifyDataSetChanged();
      pref.edit().putStringSet("santri", new HashSet<>(list)).apply();
      etNama.setText(""); etPentasmi.setText(""); etWa.setText(""); etJuz.setText(""); etHal.setText("");
      Toast.makeText(this, "Santri ditambahkan!", Toast.LENGTH_SHORT).show();
    });
  }
}
