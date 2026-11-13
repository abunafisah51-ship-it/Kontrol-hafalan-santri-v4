package com.santri.kontrolhafalanv4;
import android.os.Bundle; import android.widget.*; import androidx.appcompat.app.AppCompatActivity;
public class WaliActivity extends AppCompatActivity {
    protected void onCreate(Bundle b){ super.onCreate(b); setContentView(R.layout.activity_wali);
        TextView tv=findViewById(R.id.tvLaporan);
        tv.setText("Hafalan Hari Ini: "+BukomStorage.getHafalan(this).size()+" hafalan\nTotal Santri: "+BukomStorage.getSantri(this).size()+" Santri\n\nPesan Pengajar:\nAlhamdulillah, ananda semangat hari ini. Mohon diulang di rumah 10 menit.");
        findViewById(R.id.btnKirim).setOnClickListener(v->Toast.makeText(this,"Laporan siap dikirim ke Wali",Toast.LENGTH_SHORT).show());
    }
}
