package com.santri.kontrolhafalanv4;
import android.os.Bundle; import android.widget.*; import androidx.appcompat.app.AppCompatActivity;
public class ProgressActivity extends AppCompatActivity {
 protected void onCreate(Bundle b){ super.onCreate(b); setContentView(R.layout.activity_detail);
  ((TextView)findViewById(R.id.tvJudulSurah)).setText("📊 Progres 30 Juz");
  ((EditText)findViewById(R.id.etCatatan)).setText("Fatan\nJuz 30 ██████████ 100%\nJuz 29 ██████░░░░ 60%\nJuz 28 ██░░░░░░░░ 20%\n\nTotal Hafalan: 7,5 Juz\n\nHudzaifah - Juz 30 80%\nNabil - Juz 30 75%\nHisyam - Juz 30 90%\nKenan - Juz 30 40%");
  findViewById(R.id.btnSimpan).setVisibility(android.view.View.GONE);
 }
}
