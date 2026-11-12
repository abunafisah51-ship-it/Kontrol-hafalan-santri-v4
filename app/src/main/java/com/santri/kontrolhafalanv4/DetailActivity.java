package com.santri.kontrolhafalanv4;
import android.os.Bundle; import android.graphics.*; import android.widget.*; import android.view.*; import android.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity; import java.util.*;
public class DetailActivity extends AppCompatActivity {
 List<String> list=new ArrayList<>(); LinearLayout isi;
 void tampil(){
  isi.removeAllViews();
  TextView jml=new TextView(this); jml.setText("Total Santri: "+list.size()+" santri  •  Aktif"); jml.setTextSize(14); jml.setTypeface(Typeface.DEFAULT_BOLD); jml.setTextColor(UiHelper.HIJAU); isi.addView(jml);
  for(int i=0;i<list.size();i++){ String nm=list.get(i).trim(); if(nm.isEmpty()) continue; int idx=i;
   LinearLayout card=new LinearLayout(this); card.setOrientation(LinearLayout.HORIZONTAL); card.setBackgroundColor(Color.parseColor("#F8F9F8")); card.setPadding(30,25,30,25); LinearLayout.LayoutParams lp=new LinearLayout.LayoutParams(-1,-2); lp.setMargins(0,18,0,0); card.setLayoutParams(lp);
   TextView no=new TextView(this); no.setText(String.valueOf(i+1)); no.setTextSize(16); no.setTypeface(Typeface.DEFAULT_BOLD); no.setTextColor(Color.WHITE); no.setBackgroundColor(UiHelper.EMAS); no.setPadding(22,12,22,12); no.setGravity(Gravity.CENTER);
   TextView t=new TextView(this); t.setText("  "+nm+"  "); t.setTextSize(17); t.setTypeface(Typeface.DEFAULT_BOLD); t.setTextColor(UiHelper.TEKS); t.setLayoutParams(new LinearLayout.LayoutParams(0,-2,1));
   Button hapus=new Button(this); hapus.setText("🗑️ HAPUS"); hapus.setTextSize(12); hapus.setTypeface(Typeface.DEFAULT_BOLD); hapus.setTextColor(Color.WHITE); hapus.setBackgroundColor(Color.parseColor("#B42318"));
   hapus.setOnClickListener(v-> new AlertDialog.Builder(this).setTitle("Hapus Santri?").setMessage("Hapus "+nm+"?\nSantri yang keluar / lulus akan terhapus dari semua HP pengajar & Firebase.").setPositiveButton("YA, HAPUS",(d,w)->{ list.remove(idx); String baru=String.join(",",list); getSharedPreferences("hafalan",MODE_PRIVATE).edit().putString("daftar_santri",baru).apply(); FirebaseHelper.simpanOnline("daftar_santri","\""+baru+"\""); Toast.makeText(this,nm+" terhapus dari online",Toast.LENGTH_SHORT).show(); tampil(); }).setNegativeButton("BATAL",null).show());
   card.addView(no); card.addView(t); card.addView(hapus); isi.addView(card);
  }
  TextView tip=new TextView(this); tip.setText("Tip: Santri yang sudah lulus / keluar, pencet HAPUS agar database tidak penuh."); tip.setTextSize(12); tip.setTextColor(Color.GRAY); tip.setPadding(0,25,0,0); isi.addView(tip);
 }
 protected void onCreate(Bundle b){ super.onCreate(b);
  LinearLayout lay=new LinearLayout(this); lay.setOrientation(LinearLayout.VERTICAL); lay.setBackgroundColor(Color.WHITE);
  UiHelper.header(lay,"📋  Daftar Santri");
  ScrollView sv=new ScrollView(this); isi=new LinearLayout(this); isi.setOrientation(LinearLayout.VERTICAL); isi.setPadding(35,30,35,30);
  String data=getIntent().getStringExtra("surah_name"); if(data==null) data="Hudzaifah,Nabil,Fatan,Hisyam,Kenan";
  String bersih=data.replace("Daftar Santri:\n","").replace("Daftar Santri:","").replace("\n",",");
  list=new ArrayList<>(Arrays.asList(bersih.split(","))); tampil(); sv.addView(isi); lay.addView(sv); setContentView(lay);
 }
}
