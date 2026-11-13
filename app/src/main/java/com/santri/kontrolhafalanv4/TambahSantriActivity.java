package com.santri.kontrolhafalanv4;
import android.os.Bundle; import android.widget.*; import androidx.appcompat.app.AppCompatActivity;
public class TambahSantriActivity extends AppCompatActivity {
    protected void onCreate(Bundle b){ super.onCreate(b); setContentView(R.layout.activity_tambah_santri);
        EditText eNama=findViewById(R.id.etNama), eKelas=findViewById(R.id.etKelas), eWa=findViewById(R.id.etWa);
        findViewById(R.id.btnSimpan).setOnClickListener(v->{ String nama=eNama.getText().toString().trim(); if(nama.isEmpty()){ Toast.makeText(this,"Isi nama dulu, Abu!",Toast.LENGTH_SHORT).show(); return; }
            Santri s=new Santri(""); s.nama=nama; s.kelas=eKelas.getText().toString().trim().isEmpty()?"1":eKelas.getText().toString().trim(); s.hafalan="0 Juz"; s.wa=eWa.getText().toString().trim();
            BukomStorage.addSantriRaw(this,s.toData()); Toast.makeText(this,"Santri tersimpan!",Toast.LENGTH_SHORT).show(); finish(); });
    }
}
