package com.santri.kontrolhafalanv4;
import android.os.Bundle; import android.content.Intent; import android.graphics.*; import android.view.*; import android.widget.*;
import androidx.appcompat.app.AppCompatActivity; import java.util.Arrays; import java.util.List;
public class MainActivity extends AppCompatActivity {
 protected void onCreate(Bundle b){ super.onCreate(b);
  LinearLayout lay=new LinearLayout(this); lay.setOrientation(LinearLayout.VERTICAL); lay.setBackgroundColor(Color.WHITE);
  TextView head=new TextView(this); head.setText("🕌  KONTROL HAFALAN SANTRI\nPondok Pesantren - 30 Juz"); head.setTextSize(20); head.setTypeface(Typeface.DEFAULT_BOLD); head.setTextColor(Color.WHITE); head.setBackgroundColor(UiHelper.HIJAU); head.setPadding(45,50,45,50); lay.addView(head);
  TextView garis=new TextView(this); garis.setHeight(8); garis.setBackgroundColor(UiHelper.EMAS); lay.addView(garis);
  TextView sub=new TextView(this); sub.setText("  Hari ini: Target 3 Bagian Hafalan  •  2 Halaman Murojaah"); sub.setTextSize(13); sub.setTextColor(Color.DKGRAY); sub.setPadding(30,25,30,15); lay.addView(sub);
  FirebaseHelper.loadOnline(this);
  List<String> menu=Arrays.asList("📋 Daftar Santri","📖 Hafalan Baru","🔄 Murojaah","📊 Progres 30 Juz","📄 Laporan Wali","📈 Dashboard Pengajar","➕ Tambah Santri");
  List<String> desc=Arrays.asList("Lihat & hapus santri","Input 3 bagian / hari","Input 2 halaman / hari","Lihat 30 Juz","Untuk wali santri","Rekap hari ini","Tambah santri baru");
  ScrollView sv=new ScrollView(this); LinearLayout isi=new LinearLayout(this); isi.setOrientation(LinearLayout.VERTICAL); isi.setPadding(30,10,30,30);
  for(int i=0;i<menu.size();i++){ int pos=i;
   LinearLayout card=new LinearLayout(this); card.setOrientation(LinearLayout.VERTICAL); card.setBackgroundColor(Color.parseColor("#F8F9F8")); card.setPadding(35,30,35,30); LinearLayout.LayoutParams lp=new LinearLayout.LayoutParams(-1,-2); lp.setMargins(0,0,0,22); card.setLayoutParams(lp);
   TextView t=new TextView(this); t.setText(menu.get(i)); t.setTextSize(18); t.setTypeface(Typeface.DEFAULT_BOLD); t.setTextColor(UiHelper.HIJAU);
   TextView d=new TextView(this); d.setText(desc.get(i)); d.setTextSize(13); d.setTextColor(Color.GRAY); card.addView(t); card.addView(d);
   card.setOnClickListener(v->{ Class c=DetailActivity.class; if(pos==1)c=HafalanActivity.class; else if(pos==2)c=MurojaahActivity.class; else if(pos==3)c=ProgressActivity.class; else if(pos==4)c=WaliActivity.class; else if(pos==5)c=DashboardActivity.class; else if(pos==6)c=TambahSantriActivity.class; Intent intent=new Intent(this,c); if(pos==0){ String daftar=getSharedPreferences("hafalan",MODE_PRIVATE).getString("daftar_santri","Hudzaifah,Nabil,Fatan,Hisyam,Kenan"); intent.putExtra("surah_name","Daftar Santri:\n"+daftar.replace(",","\n")); } startActivity(intent); });
   isi.addView(card);
  }
  TextView foot=new TextView(this); foot.setText("Versi 4.2 - Online • Data tersimpan aman di Firebase"); foot.setTextSize(11); foot.setTextColor(Color.GRAY); foot.setGravity(Gravity.CENTER); isi.addView(foot);
  sv.addView(isi); lay.addView(sv); setContentView(lay);
 }
}
