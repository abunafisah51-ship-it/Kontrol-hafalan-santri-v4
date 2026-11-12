package com.santri.kontrolhafalanv4;
import android.os.Bundle; import android.widget.*; import androidx.appcompat.app.AppCompatActivity;
public class WaliActivity extends AppCompatActivity {
 protected void onCreate(Bundle b){ super.onCreate(b); setContentView(R.layout.activity_form);
  ((TextView)findViewById(R.id.tvJudul)).setText("👨‍👩‍👦 Laporan Wali Santri");
  ((EditText)findViewById(R.id.et1)).setHint("Ketik nama anak: Fatan");
  findViewById(R.id.et2).setVisibility(android.view.View.GONE); findViewById(R.id.et3).setVisibility(android.view.View.GONE); findViewById(R.id.et4).setVisibility(android.view.View.GONE); findViewById(R.id.spStatus).setVisibility(android.view.View.GONE);
  ((Button)findViewById(R.id.btnSimpan)).setText("LIHAT LAPORAN");
  findViewById(R.id.btnSimpan).setOnClickListener(v->{
   String nama=((EditText)findViewById(R.id.et1)).getText().toString();
   String h=getSharedPreferences("hafalan",MODE_PRIVATE).getString("hafalan_"+nama,"Belum ada hafalan hari ini");
   String m=getSharedPreferences("hafalan",MODE_PRIVATE).getString("murojaah_"+nama,"Belum ada murojaah hari ini");
   ((TextView)findViewById(R.id.tvHasil)).setText("Laporan "+nama+" - 12 Nov 2026\n\n"+h+"\n\n"+m+"\n\nTarget Bulan Ini: 1 Juz\nKehadiran: Hadir");
  });
 }
}
