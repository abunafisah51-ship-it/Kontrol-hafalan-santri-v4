package com.santri.kontrolhafalanv4;
import android.app.AlertDialog;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import java.util.*;
public class DetailActivity extends AppCompatActivity {
LinearLayout isi; ArrayList<String> list;
void tampil(){
isi.removeAllViews();
for(int i=0;i<list.size();i++){
final int idx=i; String raw=list.get(i).trim(); if(raw.isEmpty()) continue;
String[] p=raw.split("\\|");
String nm=p[0].trim();
String kelas=p.length>1?p[1].trim():"Kelas 1";
String juzTxt=p.length>2?p[2].trim():"";
// Kalau format lama belum ada Juz, ambil dari hafalan yang kesimpen
if(juzTxt.isEmpty()){
String j=getSharedPreferences("hafalan",MODE_PRIVATE).getString("juz_"+nm,"");
if(j.isEmpty()) j=getSharedPreferences("hafalan",MODE_PRIVATE).getString("hafalan_"+nm,"");
if(j.isEmpty()) juzTxt="0 Juz"; else juzTxt=j.contains("Juz")?j:j+" Juz";
}
LinearLayout card=new LinearLayout(this); card.setOrientation(LinearLayout.HORIZONTAL);
card.setPadding(28,24,28,24); card.setBackgroundColor(Color.WHITE);
LinearLayout.LayoutParams lp=new LinearLayout.LayoutParams(0,-2,1f); lp.setMargins(0,0,16,0);
LinearLayout txtBox=new LinearLayout(this); txtBox.setOrientation(LinearLayout.VERTICAL); txtBox.setLayoutParams(lp);
TextView t=new TextView(this); t.setText((i+1)+". "+nm); t.setTextSize(17); t.setTypeface(Typeface.SANS_SERIF,Typeface.BOLD); t.setTextColor(UiHelper.TEKS);
TextView s=new TextView(this); s.setText(kelas+"  •  "+juzTxt); s.setTextSize(13); s.setTypeface(Typeface.SANS_SERIF); s.setTextColor(UiHelper.ABU);
txtBox.addView(t); txtBox.addView(s); card.addView(txtBox);
Button hapus=new Button(this); hapus.setText("Hapus"); hapus.setTextSize(12); hapus.setTypeface(Typeface.SANS_SERIF,Typeface.BOLD); hapus.setTextColor(Color.WHITE); hapus.setBackgroundColor(Color.parseColor("#B42318")); hapus.setAllCaps(false);
hapus.setOnClickListener(v-> new AlertDialog.Builder(this).setTitle("Hapus Santri?").setMessage("Hapus "+nm+"? Santri yang lulus / keluar akan terhapus dari semua HP pengajar dan Firebase.").setPositiveButton("YA, HAPUS",(d,w)->{ list.remove(idx); String baru=String.join(",",list); getSharedPreferences("hafalan",MODE_PRIVATE).edit().putString("daftar_santri",baru).apply(); FirebaseHelper.simpanOnline("daftar_santri","\""+baru+"\""); Toast.makeText(this,nm+" terhapus dari online",Toast.LENGTH_SHORT).show(); tampil(); }).setNegativeButton("BATAL",null).show());
card.addView(hapus); isi.addView(card);
}
TextView tip=new TextView(this); tip.setText("Santri yang sudah lulus / keluar, tekan Hapus agar database tetap ringan."); tip.setTextSize(12); tip.setTypeface(Typeface.SANS_SERIF); tip.setTextColor(UiHelper.ABU); tip.setPadding(4,8,4,0); isi.addView(tip);
}
protected void onCreate(Bundle b){ super.onCreate(b); UiHelper.setup(this);
LinearLayout lay=UiHelper.page(this,"DAFTAR SANTRI","Kelola santri aktif  •  Hapus jika lulus / keluar");
ScrollView sv=new ScrollView(this); isi=new LinearLayout(this); isi.setOrientation(LinearLayout.VERTICAL); isi.setPadding(32,28,32,28);
String data=getIntent().getStringExtra("surah_name");
if(data==null) data="Hudzaifah,Nabil,Fatan,Hisyam,Kenan";
String bersih=data.replace("Daftar Santri:\n","").replace("Daftar Santri:","").replace("\n",",");
list=new ArrayList<>(Arrays.asList(bersih.split(",")));
tampil(); sv.addView(isi); lay.addView(sv); setContentView(lay);
}
}
