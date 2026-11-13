package com.santri.kontrolhafalanv4;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Locale;
public class HafalanBaruActivity extends AppCompatActivity {
    Spinner spSantri, spNilai;
    EditText etSurah, etDari, etSampai;
    Button btnSimpan;
    TextView tvTanggal, tvInfo;
    List<String> listSantri = new ArrayList<>();
    List<String> listTampil = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hafalan_baru);
        spSantri=findViewById(R.id.spSantri);
        spNilai=findViewById(R.id.spNilai);
        etSurah=findViewById(R.id.etSurah);
        etDari=findViewById(R.id.etDari);
        etSampai=findViewById(R.id.etSampai);
        btnSimpan=findViewById(R.id.btnSimpan);
        tvTanggal=findViewById(R.id.tvTanggal);
        tvInfo=findViewById(R.id.tvInfo);
        String tgl=new SimpleDateFormat("dd MMMM yyyy", new Locale("id","ID")).format(new Date());
        tvTanggal.setText("📅 "+tgl+"  •  Target: 3 Bagian / Hari");
        ArrayAdapter<String> adNilai=new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, new String[]{"A - Lancar","B - Cukup Lancar","C - Perlu Bimbingan"});
        spNilai.setAdapter(adNilai);
        SharedPreferences pref=getSharedPreferences("BUKOM", MODE_PRIVATE);
        listSantri=new ArrayList<>(pref.getStringSet("santri", new HashSet<>()));
        Collections.sort(listSantri);
        for(String s: listSantri){
            String nama=s; try{ nama=s.substring(s.indexOf("Nama:")+5, s.indexOf("\n")).trim(); }catch(Exception e){}
            String kelas="1"; try{ int a=s.indexOf("Kelas:"); String sub=s.substring(a+6); int p=sub.indexOf(" |"); if(p>0) kelas=sub.substring(0,p).trim(); }catch(Exception e){}
            listTampil.add(nama+" - Kelas "+kelas);
        }
        if(listTampil.isEmpty()) listTampil.add("Belum ada santri - tambahkan dulu");
        ArrayAdapter<String> ad=new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, listTampil);
        spSantri.setAdapter(ad);
        tvInfo.setText("Santri terpilih: "+listSantri.size()+" santri aktif");
        btnSimpan.setOnClickListener(v->{
            String surah=etSurah.getText().toString().trim();
            String dari=etDari.getText().toString().trim();
            String sampai=etSampai.getText().toString().trim();
            String nilai=spNilai.getSelectedItem().toString();
            if(listSantri.isEmpty()){ Toast.makeText(this,"Belum ada santri, tambahkan dulu ya",Toast.LENGTH_SHORT).show(); return; }
            if(surah.isEmpty()||dari.isEmpty()||sampai.isEmpty()){ Toast.makeText(this,"Lengkapi Surah dan Ayat dulu ya",Toast.LENGTH_SHORT).show(); return; }
            String namaSantri=listTampil.get(spSantri.getSelectedItemPosition());
            String data="Hafalan Baru | "+namaSantri+" | "+surah+" | Ayat "+dari+" - "+sampai+" | "+nilai+" | "+tgl;
            Set<String> set=new HashSet<>(pref.getStringSet("hafalan",new HashSet<>()));
            set.add(data);
            pref.edit().putStringSet("hafalan",set).apply();
            Toast.makeText(this,"✅ Hafalan "+namaSantri+" tersimpan",Toast.LENGTH_LONG).show();
            etSurah.setText(""); etDari.setText(""); etSampai.setText("");
            finish();
        });
    }
}
