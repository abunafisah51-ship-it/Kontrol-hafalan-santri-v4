package com.santri.kontrolhafalanv4;
import android.os.Bundle; import android.content.Intent; import android.widget.TextView; import androidx.appcompat.app.AppCompatActivity;
public class DashboardActivity extends AppCompatActivity {
    protected void onCreate(Bundle b){ super.onCreate(b); setContentView(R.layout.activity_dashboard);
        TextView tv = findViewById(R.id.tvRekap);
        tv.setText("Total "+BukomStorage.getSantri(this).size()+" Santri • "+BukomStorage.getHafalan(this).size()+" Hafalan");
        findViewById(R.id.btnSantri).setOnClickListener(v->startActivity(new Intent(this, DataSantriActivity.class)));
        findViewById(R.id.btnTambah).setOnClickListener(v->startActivity(new Intent(this, TambahSantriActivity.class)));
        findViewById(R.id.btnHafalan).setOnClickListener(v->startActivity(new Intent(this, HafalanBaruActivity.class)));
        findViewById(R.id.btnWali).setOnClickListener(v->startActivity(new Intent(this, WaliActivity.class)));
    }
    protected void onResume(){ super.onResume(); TextView tv=findViewById(R.id.tvRekap); if(tv!=null) tv.setText("Total "+BukomStorage.getSantri(this).size()+" Santri • "+BukomStorage.getHafalan(this).size()+" Hafalan"); }
}
