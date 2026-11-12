package com.santri.kontrolhafalanv4;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
public class PendahuluanActivity extends AppCompatActivity {
  @Override protected void onCreate(Bundle b) {
    super.onCreate(b);
    setContentView(R.layout.activity_pendahuluan);
    TextView tv = findViewById(R.id.tvPendahuluan);
    tv.setText("Assalamu'alaikum Warahmatullahi Wabarakatuh.\n\nBUKOM SANTRI - Kontrol Hafalan Santri\nPondok Pesantren - Program 30 Juz - Online\n\nPENDAHULUAN\n\n1. Membantu santri mengontrol hafalan setiap hari secara terarah dan terukur.\n\n2. Membantu santri mencapai target Program 30 Juz sesuai jenjang pendidikan.\n\n3. Memberikan transparansi kepada Wali Santri tentang perkembangan hafalan putra-putrinya.\n\n4. Memudahkan Admin dalam mengelola data santri, Pentasmi', dan laporan hafalan.\n\n5. Memudahkan Pentasmi' dalam membimbing dan menginput hafalan santri dengan amanah.");
    Button btn = findViewById(R.id.btnLanjut);
    btn.setOnClickListener(v -> {
      startActivity(new Intent(PendahuluanActivity.this, LoginActivity.class));
      finish();
    });
  }
}
