package com.santri.kontrolhafalanv4;
import android.os.Bundle; import android.widget.*; import androidx.appcompat.app.AppCompatActivity;
import java.util.*;
public class TambahSantriActivity extends AppCompatActivity {
 protected void onCreate(Bundle b){ super.onCreate(b); setContentView(R.layout.activity_form);
  ((TextView)findViewById(R.id.tvJudul)).setText("➕ Tambah Santri Baru");
  ((EditText)findViewById(R.id.et1)).setHint("Nama Santri Baru: misal Ahmad");
  findViewById(R.id.et2).setVisibility(android.view.View.GONE); findViewById(R.id.et3).setVisibility(android.view.View.GONE); findViewById(R.id.et4).setVisibility(android.view.View.GONE); findViewById(R.id.spStatus).setVisibility(android.view.View.GONE);
  ((Button)findViewById(R.id.btnSimpan)).setText("TAMBAH SANTRI");
  findViewById(R.id.btnSimpan).setOnClickListener(v->{
   String nama=((EditText)findViewById(R.id.et1)).getText().toString().trim();
   if(nama.isEmpty()){ Toast.makeText(this,"Isi dulu namanya",Toast.LENGTH_SHORT).show(); return; }
   String lama=getSharedPreferences("hafalan",MODE_PRIVATE).getString("daftar_santri","Hudzaifah,Nabil,Fatan,Hisyam,Kenan");
   if(!lama.contains(nama)){
     getSharedPreferences("hafalan",MODE_PRIVATE).edit().putString("daftar_santri",lama+","+nama).apply();
     Toast.makeText(this,nama+" berhasil ditambah!",Toast.LENGTH_SHORT).show(); finish();
   } else Toast.makeText(this,"Udah ada",Toast.LENGTH_SHORT).show();
  });
 }
}
