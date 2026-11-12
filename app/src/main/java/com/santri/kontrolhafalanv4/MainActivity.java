package com.santri.kontrolhafalanv4;
import android.content.Intent; import android.os.Bundle; import android.widget.*; import androidx.appcompat.app.AppCompatActivity; import java.util.Arrays; import java.util.List;
public class MainActivity extends AppCompatActivity {
 protected void onCreate(Bundle b){ super.onCreate(b);
  List<String> menu = Arrays.asList("👦 Daftar Santri","📖 Hafalan Baru","🔁 Murojaah","📊 Progres 30 Juz","👨‍👩‍👦 Laporan Wali","📈 Dashboard Pengajar","➕ Tambah Santri");
  ListView lv = new ListView(this);
  lv.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, menu));
  setContentView(lv);
  lv.setOnItemClickListener((p,v,pos,id)->{
   Class c = DetailActivity.class;
   if(pos==1) c=HafalanActivity.class; else if(pos==2) c=MurojaahActivity.class; else if(pos==3) c=ProgressActivity.class; else if(pos==4) c=WaliActivity.class; else if(pos==5) c=DashboardActivity.class; else if(pos==6) c=TambahSantriActivity.class;
   Intent i=new Intent(this,c);
   if(pos==0){ String daftar=getSharedPreferences("hafalan",MODE_PRIVATE).getString("daftar_santri","Hudzaifah,Nabil,Fatan,Hisyam,Kenan"); i.putExtra("surah_name","Daftar Santri:\n"+daftar.replace(",","\n")); }
   startActivity(i);
  });
 }
}
