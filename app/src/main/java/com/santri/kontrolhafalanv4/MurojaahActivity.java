package com.santri.kontrolhafalanv4;
import android.os.Bundle; import android.widget.*; import androidx.appcompat.app.AppCompatActivity;
public class MurojaahActivity extends AppCompatActivity {
 protected void onCreate(Bundle b){ super.onCreate(b); setContentView(R.layout.activity_form);
  ((TextView)findViewById(R.id.tvJudul)).setText("🔁 Murojaah - 2 Lembar / Hari");
  ((EditText)findViewById(R.id.et2)).setHint("Surat yang dimurojaah");
  ((EditText)findViewById(R.id.et3)).setHint("Halaman: 1-2");
  Spinner sp=findViewById(R.id.spStatus); sp.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, new String[]{"✅ Lancar","⚠️ Perlu Diulang"}));
  findViewById(R.id.btnSimpan).setOnClickListener(v->{
   String nama=((EditText)findViewById(R.id.et1)).getText().toString();
   String data="Murojaah: "+((EditText)findViewById(R.id.et2)).getText().toString()+" Hal "+((EditText)findViewById(R.id.et3)).getText().toString()+" - "+sp.getSelectedItem().toString();
   getSharedPreferences("hafalan",MODE_PRIVATE).edit().putString("murojaah_"+nama,data).apply();
   Toast.makeText(this,"Murojaah tersimpan",Toast.LENGTH_SHORT).show(); finish();
  });
 }
}
