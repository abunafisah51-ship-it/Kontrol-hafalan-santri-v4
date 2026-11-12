package com.santri.kontrolhafalanv4;
import android.os.Bundle; import android.graphics.*; import android.widget.*;
import androidx.appcompat.app.AppCompatActivity; import java.util.*;
public class MurojaahActivity extends AppCompatActivity {
 protected void onCreate(Bundle b){ super.onCreate(b); UiHelper.setup(this);
  LinearLayout lay=UiHelper.page(this,"MUROJAAH","Target: 2 Halaman / Hari");
  ScrollView sv=new ScrollView(this); LinearLayout isi=new LinearLayout(this); isi.setOrientation(LinearLayout.VERTICAL); isi.setPadding(32,28,32,28);
  LinearLayout card=UiHelper.card(this);
  card.addView(UiHelper.label(this,"Nama Santri"));
  Spinner sp=new Spinner(this); String d=getSharedPreferences("hafalan",MODE_PRIVATE).getString("daftar_santri","Hudzaifah,Nabil,Fatan,Hisyam,Kenan"); List<String> ls=new ArrayList<>(Arrays.asList(d.split(","))); sp.setAdapter(new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,ls)); card.addView(sp);
  card.addView(UiHelper.label(this,"Surah yang di-Murojaah")); EditText e1=UiHelper.input(this,"Contoh: Al-Kahfi"); card.addView(e1);
  card.addView(UiHelper.label(this,"Halaman")); EditText e2=UiHelper.input(this,"Contoh: Halaman 1 - 2"); card.addView(e2);
  card.addView(UiHelper.label(this,"Keterangan")); EditText e3=UiHelper.input(this,"Contoh: Lancar / Masih terbata"); card.addView(e3);
  isi.addView(card);
  Button sm=UiHelper.tombol(this,"Simpan Murojaah"); sm.setOnClickListener(v->{ Toast.makeText(this,"Murojaah "+sp.getSelectedItem()+" tersimpan",Toast.LENGTH_SHORT).show(); finish(); }); isi.addView(sm);
  sv.addView(isi); lay.addView(sv); setContentView(lay);
 }
}
