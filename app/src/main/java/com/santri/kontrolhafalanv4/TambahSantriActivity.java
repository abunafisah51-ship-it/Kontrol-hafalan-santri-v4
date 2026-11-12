package com.santri.kontrolhafalanv4;
import android.os.Bundle; import android.graphics.*; import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
public class TambahSantriActivity extends AppCompatActivity {
 protected void onCreate(Bundle b){ super.onCreate(b); UiHelper.setup(this);
  LinearLayout lay=UiHelper.page(this,"TAMBAH SANTRI","Santri baru langsung online ke semua HP");
  ScrollView sv=new ScrollView(this); LinearLayout isi=new LinearLayout(this); isi.setOrientation(LinearLayout.VERTICAL); isi.setPadding(32,28,32,28);
  LinearLayout card=UiHelper.card(this); card.addView(UiHelper.label(this,"Nama Santri Baru")); EditText e=UiHelper.input(this,"Contoh: Umar"); card.addView(e); isi.addView(card);
  Button sm=UiHelper.tombol(this,"Simpan & Kirim Online"); sm.setOnClickListener(v->{ String nm=e.getText().toString().trim(); if(nm.isEmpty()){ Toast.makeText(this,"Isi dulu namanya",Toast.LENGTH_SHORT).show(); return; } String lama=getSharedPreferences("hafalan",MODE_PRIVATE).getString("daftar_santri","Hudzaifah,Nabil,Fatan,Hisyam,Kenan"); String baru=lama.isEmpty()? nm : lama+","+nm; getSharedPreferences("hafalan",MODE_PRIVATE).edit().putString("daftar_santri",baru).apply(); FirebaseHelper.simpanOnline("daftar_santri","\""+baru+"\""); Toast.makeText(this,nm+" tersimpan & terkirim online",Toast.LENGTH_SHORT).show(); finish(); }); isi.addView(sm);
  sv.addView(isi); lay.addView(sv); setContentView(lay);
 }
}
