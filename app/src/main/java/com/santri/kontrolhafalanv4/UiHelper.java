package com.santri.kontrolhafalanv4;
import android.graphics.*; import android.widget.*; import android.content.Context; import android.view.Gravity;
public class UiHelper {
 public static int HIJAU=Color.parseColor("#0F5132"); public static int HIJAU_MUDA=Color.parseColor("#E8F5E9"); public static int EMAS=Color.parseColor("#C9A227"); public static int TEKS=Color.parseColor("#1A1A1A"); public static int ABU=Color.parseColor("#6B7280"); public static int CARD=Color.parseColor("#FFFFFF"); public static int BG=Color.parseColor("#F3F4F6");
 public static void setup(androidx.appcompat.app.AppCompatActivity a){ if(a.getSupportActionBar()!=null) a.getSupportActionBar().hide(); }
 public static LinearLayout page(Context c,String title,String sub){
  LinearLayout lay=new LinearLayout(c); lay.setOrientation(LinearLayout.VERTICAL); lay.setBackgroundColor(BG);
  LinearLayout head=new LinearLayout(c); head.setOrientation(LinearLayout.VERTICAL); head.setBackgroundColor(HIJAU); head.setPadding(48,42,48,42);
  TextView t=new TextView(c); t.setText(title); t.setTextSize(20); t.setTypeface(Typeface.SANS_SERIF,Typeface.BOLD); t.setTextColor(Color.WHITE); head.addView(t);
  if(sub!=null){ TextView s=new TextView(c); s.setText(sub); s.setTextSize(13); s.setTypeface(Typeface.SANS_SERIF); s.setTextColor(Color.parseColor("#D1E7DD")); s.setPadding(0,6,0,0); head.addView(s); }
  lay.addView(head);
  TextView g=new TextView(c); g.setHeight(6); g.setBackgroundColor(EMAS); lay.addView(g);
  return lay;
 }
 public static LinearLayout card(Context c){ LinearLayout card=new LinearLayout(c); card.setOrientation(LinearLayout.VERTICAL); card.setBackgroundColor(CARD); card.setPadding(40,32,40,32); LinearLayout.LayoutParams lp=new LinearLayout.LayoutParams(-1,-2); lp.setMargins(0,0,0,20); card.setLayoutParams(lp); card.setElevation(4); return card; }
 public static TextView title(Context c,String s){ TextView t=new TextView(c); t.setText(s); t.setTextSize(17); t.setTypeface(Typeface.SANS_SERIF,Typeface.BOLD); t.setTextColor(HIJAU); return t; }
 public static TextView desc(Context c,String s){ TextView t=new TextView(c); t.setText(s); t.setTextSize(13); t.setTypeface(Typeface.SANS_SERIF); t.setTextColor(ABU); t.setPadding(0,4,0,0); return t; }
 public static TextView label(Context c,String s){ TextView t=new TextView(c); t.setText(s); t.setTextSize(14); t.setTypeface(Typeface.SANS_SERIF,Typeface.BOLD); t.setTextColor(HIJAU); t.setPadding(0,22,0,8); return t; }
 public static EditText input(Context c,String hint){ EditText e=new EditText(c); e.setHint(hint); e.setTextSize(16); e.setTypeface(Typeface.SANS_SERIF); e.setTextColor(TEKS); e.setHintTextColor(ABU); e.setBackgroundColor(Color.WHITE); e.setPadding(32,28,32,28); return e; }
 public static Button tombol(Context c,String s){ Button b=new Button(c); b.setText(s); b.setTextSize(16); b.setTypeface(Typeface.SANS_SERIF,Typeface.BOLD); b.setTextColor(Color.WHITE); b.setBackgroundColor(HIJAU); b.setPadding(0,32,0,32); b.setAllCaps(false); return b; }
 public static TextView section(Context c,String s){ TextView t=new TextView(c); t.setText(s); t.setTextSize(13); t.setTypeface(Typeface.SANS_SERIF,Typeface.BOLD); t.setTextColor(ABU); t.setPadding(4,10,4,12); return t; }
}
