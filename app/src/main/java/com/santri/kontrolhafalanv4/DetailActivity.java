package com.santri.kontrolhafalanv4;
import android.os.Bundle; import android.graphics.*; import android.widget.*; import android.view.Gravity; import android.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity; import java.util.*;
public class DetailActivity extends AppCompatActivity {
 List<String> list=new ArrayList<>(); LinearLayout isi;
 void tampil(){
  isi.removeAllViews();
  LinearLayout top=UiHelper.card(this); top.setOrientation(LinearLayout.HORIZONTAL);
  TextView a=new TextView(this); a.setText("Total Santri"); a.setTextSize(14); a.setTypeface(Typeface.SANS_SERIF,Typeface.BOLD); a.setTextColor(UiHelper.ABU); a.setLayoutParams(new LinearLayout.LayoutParams(0,-2,1)); top.addView(a);
  TextView bb=new TextView(this); bb.setText(list.size()+" Santri Aktif"); bb.setTextSize(16); bb.setTypeface(Typeface.SANS_SERIF,Typeface.BOLD); bb.setTextColor(UiHelper.HIJAU); top.addView(bb); isi.addView(top);
  for(int i=0;i<list.size();i++){ String nm=list.get(i).trim(); if(nm.isEmpty()) continue; int idx=i;
   LinearLayout card=UiHelper.card(this); card.setOrientation(LinearLayout.HORIZONTAL);
   TextView no=new TextView(this); no.setText(String.valueOf(i+1)); no.setTextSize(15); no.setTypeface(Typeface.SANS_SERIF,Typeface.BOLD); no.setTextColor(Color.WHITE); no.setBackgroundColor(UiHelper.EMAS); no.setPadding(20,12,20,12); no.setGravity(Gravity.CENTER); card.addView(no);
   TextView t=new TextView(this); t.setText("  "+nm); t.setTextSize(17); t.setTypeface(Typeface.SANS_SERIF,Typeface.BOLD); t.setTextColor(UiHelper.TEKS); t.setLayoutParams(new LinearLayout.LayoutParams(0,-2,1)); card.addView(t);
   Button hapus=new Button(this); hapus.setText("Hapus"); hapus.setTextSize(12); hapus.setTypeface(Typeface.SANS_SERIF,Typeface.BOLD); hapus.setTextColor(Color.WHITE); hapus.setBackgroundColor(Color.parseColor("#B42318")); hapus.setAllCaps(false);
   hapus.setOnClickListener(v-> new AlertDialog.Builder(this).setTitle("Hapus Santri?").setMessage("Hapus "+nm+"? Santri yang lulus / keluar akan terhapus dari semua HP pengajar dan Firebase.").setPositiveButton("YA, HAPUS",(d,w)->{ list.remove(idx); String baru=String.join(",",list); getSharedPreferences("hafalan",MODE_PRIVATE).edit().putString("daftar_santri",baru).apply(); FirebaseHelper.simpanOnline("daftar_santri","\""+baru+"\""); Toast.makeText(this,nm+" terhapus dari online",Toast.LENGTH_SHORT).show(); tampil(); }).setNegativeButton("BATAL",null).show());
   card.addView(hapus); isi.addView(card);
  }
  TextView tip=new TextView(this); tip.setText("Santri yang sudah lulus / keluar, tekan Hapus agar database tetap ringan."); tip.setTextSize(12); tip.setTypeface(Typeface.SANS_SERIF); tip.setTextColor(UiHelper.ABU); tip.setPadding(4,8,4,0); isi.addView(tip);
 }
 protected void onCreate(Bundle b){ super.onCreate(b); UiHelper.setup(this);
  LinearLayout lay=UiHelper.page(this,"DAFTAR SANTRI","Kelola santri aktif  •  Hapus jika lulus / keluar");
  ScrollView sv=new ScrollView(this); isi=new LinearLayout(this); isi.setOrientation(LinearLayout.VERTICAL); isi.setPadding(32,28,32,28);
  String data=getIntent().getStringExtra("surah_name"); if(data==null) data="Hudzaifah,Nabil,Fatan,Hisyam,Kenan";
  String bersih=data.replace("Daftar Santri:\n","").replace("Daftar Santri:","").replace("\n",",");
  list=new ArrayList<>(Arrays.asList(bersih.split(","))); tampil(); sv.addView(isi); lay.addView(sv); setContentView(lay);
 }
}
