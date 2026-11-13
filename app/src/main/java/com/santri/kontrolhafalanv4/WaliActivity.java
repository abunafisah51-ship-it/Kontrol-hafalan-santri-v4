package com.santri.kontrolhafalanv4;
import android.os.Bundle; import android.graphics.*; import android.widget.*;
import androidx.appcompat.app.AppCompatActivity; import java.util.*;
public class WaliActivity extends AppCompatActivity {
 protected void onCreate(Bundle b){ super.onCreate(b); UiHelper.setup(this);
  LinearLayout lay=UiHelper.page(this,"LAPORAN WALI","Rekap untuk wali santri");
  ScrollView sv=new ScrollView(this); LinearLayout isi=new LinearLayout(this); isi.setOrientation(LinearLayout.VERTICAL); isi.setPadding(32,28,32,28);
  LinearLayout card=UiHelper.card(this); card.addView(UiHelper.label(this,"Pilih Santri"));
  Spinner sp=new Spinner(this); String d=getSharedPreferences("hafalan",MODE_PRIVATE).getString("daftar_santri","Hudzaifah,Nabil,Fatan,Hisyam,Kenan"); List<String> ls=new ArrayList<>(Arrays.asList(d.split(","))); sp.setAdapter(new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,ls)); card.addView(sp);
  card.addView(UiHelper.label(this,"Isi Laporan")); TextView t=new TextView(this); t.setText("Hafalan Hari Ini: 3 paragraf\nMurojaah: 2 ½ lembar\nTotal: 2 Juz\n\nPesan Pengajar:\nAlhamdulillah, ananda semangat hari ini. Mohon diulang di rumah 10 menit."); t.setTextSize(15); t.setTypeface(Typeface.SANS_SERIF); t.setTextColor(UiHelper.TEKS); card.addView(t); isi.addView(card);
  Button sm=UiHelper.tombol(this,"Kirim ke Wali (WA)"); sm.setOnClickListener(v->{ Toast.makeText(this,"Laporan siap dikirim ke Wali "+sp.getSelectedItem(),Toast.LENGTH_SHORT).show(); }); isi.addView(sm);
  sv.addView(isi); lay.addView(sv); setContentView(lay);
 }
}
