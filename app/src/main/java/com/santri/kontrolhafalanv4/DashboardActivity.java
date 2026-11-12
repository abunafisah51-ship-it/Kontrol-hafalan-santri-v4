package com.santri.kontrolhafalanv4;
import android.os.Bundle; import android.widget.*; import androidx.appcompat.app.AppCompatActivity;
public class DashboardActivity extends AppCompatActivity {
 protected void onCreate(Bundle b){ super.onCreate(b); setContentView(R.layout.activity_detail);
  ((TextView)findViewById(R.id.tvJudulSurah)).setText("📈 Dashboard Pengajar");
  ((EditText)findViewById(R.id.etCatatan)).setText("Hudzaifah | 3 paragraf | 2 lembar | 🟢\nNabil | 3 paragraf | 2 lembar | 🟢\nFatan | 3 paragraf | 2 lembar | 🟡 Perlu Perhatian\nHisyam | 3 paragraf | 2 lembar | 🟢\nKenan | 1 paragraf | 1 lembar | 🔴 Tertinggal\n\n🟢 = Sesuai Target\n🟡 = Perlu Perhatian\n🔴 = Tertinggal");
  findViewById(R.id.btnSimpan).setVisibility(android.view.View.GONE);
 }
}
