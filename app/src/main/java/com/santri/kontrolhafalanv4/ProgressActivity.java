package com.santri.kontrolhafalanv4;
import android.os.Bundle; import android.graphics.*; import android.widget.*;
import androidx.appcompat.app.AppCompatActivity; import java.util.*;
public class ProgressActivity extends AppCompatActivity {
 protected void onCreate(Bundle b){ super.onCreate(b); UiHelper.setup(this);
  LinearLayout lay=UiHelper.page(this,"PROGRES 30 JUZ","Pantau progres tiap santri");
  ScrollView sv=new ScrollView(this); LinearLayout isi=new LinearLayout(this); isi.setOrientation(LinearLayout.VERTICAL); isi.setPadding(32,28,32,28);
  String d=getSharedPreferences("hafalan",MODE_PRIVATE).getString("daftar_santri","Hudzaifah,Nabil,Fatan,Hisyam,Kenan"); List<String> ls=new ArrayList<>(Arrays.asList(d.split(",")));
  for(String nm:ls){ if(nm.trim().isEmpty()) continue;
   LinearLayout card=UiHelper.card(this);
   TextView t=UiHelper.title(this,nm.trim()); card.addView(t);
   ProgressBar pb=new ProgressBar(this,null,android.R.attr.progressBarStyleHorizontal); pb.setMax(30); pb.setProgress(2); pb.setPadding(0,16,0,8); card.addView(pb);
   TextView p=new TextView(this); p.setText("2 / 30 Juz  •  6%"); p.setTextSize(13); p.setTypeface(Typeface.SANS_SERIF); p.setTextColor(UiHelper.ABU); card.addView(p);
   isi.addView(card);
  }
  sv.addView(isi); lay.addView(sv); setContentView(lay);
 }
}
