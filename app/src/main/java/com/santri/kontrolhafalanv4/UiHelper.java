package com.santri.kontrolhafalanv4;
import android.graphics.*; import android.widget.*;
public class UiHelper {
 public static int HIJAU=Color.parseColor("#0F5132"); public static int EMAS=Color.parseColor("#C9A227"); public static int TEKS=Color.parseColor("#222222");
 public static void header(android.widget.LinearLayout lay,String j){
  android.widget.TextView t=new android.widget.TextView(lay.getContext()); t.setText(j); t.setTextSize(20); t.setTypeface(Typeface.DEFAULT_BOLD); t.setTextColor(Color.WHITE); t.setBackgroundColor(HIJAU); t.setPadding(40,45,40,45); lay.addView(t);
  android.widget.TextView g=new android.widget.TextView(lay.getContext()); g.setHeight(8); g.setBackgroundColor(EMAS); lay.addView(g);
 }
 public static android.widget.TextView label(android.content.Context c,String s){ android.widget.TextView t=new android.widget.TextView(c); t.setText(s); t.setTextSize(15); t.setTypeface(Typeface.SANS_SERIF,Typeface.BOLD); t.setTextColor(HIJAU); t.setPadding(0,25,0,8); return t; }
 public static android.widget.Button tombol(android.content.Context c,String s){ android.widget.Button b=new android.widget.Button(c); b.setText(s); b.setTextSize(16); b.setTypeface(Typeface.DEFAULT_BOLD); b.setTextColor(Color.WHITE); b.setBackgroundColor(HIJAU); b.setPadding(0,30,0,30); return b; }
}
