package com.santri.kontrolhafalanv4;
import android.os.Bundle; import android.graphics.*; import android.widget.*;
import androidx.appcompat.app.AppCompatActivity; import java.util.*;
public class HafalanActivity extends AppCompatActivity {
 protected void onCreate(Bundle b){ super.onCreate(b); UiHelper.setup(this);
  LinearLayout lay=UiHelper.page(this,"HAFALAN BARU","Target: 3 Bagian / Hari");
  ScrollView sv=new ScrollView(this); LinearLayout isi=new LinearLayout(this); isi.setOrientation(LinearLayout.VERTICAL); isi.setPadding(32,28,32,28);
  LinearLayout card=UiHelper.card(this);
  card.addView(UiHelper.label(this,"Nama Santri"));
  Spinner sp=new Spinner(this); String d=getSharedPreferences("hafalan",MODE_PRIVATE).getString("daftar_santri","Hudzaifah,Nabil,Fatan,Hisyam,Kenan"); List<String> ls=new ArrayList<>(Arrays.asList(d.split(","))); sp.setAdapter(new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,ls)); card.addView(sp);
  card.addView(UiHelper.label(this,"Surah / Juz")); EditText e1=UiHelper.input(this,"Contoh: Al-Mulk / Juz 30"); card.addView(e1);
  card.addView(UiHelper.label(this,"Dari Ayat - Sampai Ayat")); EditText e2=UiHelper.input(this,"Contoh: Ayat 1 - 12"); card.addView(e2);
  card.addView(UiHelper.label(this,"Nilai")); EditText e3=UiHelper.input(this,"Contoh: A - Lancar"); card.addView(e3);
  isi.addView(card);
  Button sm=UiHelper.tombol(this,"Simpan Hafalan"); sm.setOnClickListener(v->{ Toast.makeText(this,"Hafalan "+sp.getSelectedItem()+" tersimpan",Toast.LENGTH_SHORT).show(); finish(); }); isi.addView(sm);
  sv.addView(isi); lay.addView(sv); setContentView(lay);
 }
}
