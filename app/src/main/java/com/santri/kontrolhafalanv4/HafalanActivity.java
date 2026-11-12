package com.santri.kontrolhafalanv4;
import android.os.Bundle; import android.widget.*; import androidx.appcompat.app.AppCompatActivity;
public class HafalanActivity extends AppCompatActivity {
 protected void onCreate(Bundle b){ super.onCreate(b); setContentView(R.layout.activity_form);
  ((TextView)findViewById(R.id.tvJudul)).setText("📖 Hafalan Baru - 3 Paragraf");
  Spinner sp=findViewById(R.id.spStatus); sp.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, new String[]{"✅ Lancar","⚠️ Perlu Diulang"}));
  findViewById(R.id.btnSimpan).setOnClickListener(v->{
   String nama=((EditText)findViewById(R.id.et1)).getText().toString();
   String data="Hafalan Baru: "+((EditText)findViewById(R.id.et2)).getText().toString()+" Ayat "+((EditText)findViewById(R.id.et3)).getText().toString()+" - "+sp.getSelectedItem().toString()+"\nCatatan: "+((EditText)findViewById(R.id.et4)).getText().toString();
   getSharedPreferences("hafalan",MODE_PRIVATE).edit().putString("hafalan_"+nama,data).apply();
   Toast.makeText(this,"Tersimpan untuk "+nama,Toast.LENGTH_SHORT).show(); finish();
  });
 }
}
