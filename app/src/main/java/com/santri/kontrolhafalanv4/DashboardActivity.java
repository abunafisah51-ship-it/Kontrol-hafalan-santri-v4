package com.santri.kontrolhafalanv4;
import android.os.Bundle; import android.graphics.*; import android.widget.*;
import androidx.appcompat.app.AppCompatActivity; import java.util.*;
public class DashboardActivity extends AppCompatActivity {
 protected void onCreate(Bundle b){ super.onCreate(b); UiHelper.setup(this);
  LinearLayout lay=UiHelper.page(this,"DASHBOARD PENGAJAR","Rekap harian pengajar");
  ScrollView sv=new ScrollView(this); LinearLayout isi=new LinearLayout(this); isi.setOrientation(LinearLayout.VERTICAL); isi.setPadding(32,28,32,28);
  String d=getSharedPreferences("hafalan",MODE_PRIVATE).getString("daftar_santri","Hudzaifah,Nabil,Fatan,Hisyam,Kenan"); int total=new ArrayList<>(Arrays.asList(d.split(","))).size();
  String[][] data={{"Total Santri Aktif",total+" Santri"},{"Hafalan Hari Ini","3 Bagian / Santri"},{"Murojaah Hari Ini","2 Halaman / Santri"},{"Target Program","30 Juz"}};
  for(String[] r:data){ LinearLayout card=UiHelper.card(this); card.setOrientation(LinearLayout.HORIZONTAL); TextView a=new TextView(this); a.setText(r[0]); a.setTextSize(15); a.setTypeface(Typeface.SANS_SERIF,Typeface.BOLD); a.setTextColor(UiHelper.HIJAU); a.setLayoutParams(new LinearLayout.LayoutParams(0,-2,1)); TextView bb=new TextView(this); bb.setText(r[1]); bb.setTextSize(15); bb.setTypeface(Typeface.SANS_SERIF,Typeface.BOLD); bb.setTextColor(UiHelper.TEKS); card.addView(a); card.addView(bb); isi.addView(card); }
  sv.addView(isi); lay.addView(sv); setContentView(lay);
 }
}
