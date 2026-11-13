package com.santri.kontrolhafalanv4;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.*;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import java.util.*;
public class DataSantriActivity extends AppCompatActivity {
    LinearLayout container;
    EditText etCari;
    TextView tvTotal;
    SharedPreferences pref;
    List<String> semua = new ArrayList<>();
    List<String> tampil = new ArrayList<>();
    String peran = "GURU";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_santri);
        container = findViewById(R.id.containerSantri);
        etCari = findViewById(R.id.etCari);
        tvTotal = findViewById(R.id.tvTotal);
        pref = getSharedPreferences("BUKOM", MODE_PRIVATE);
        peran = pref.getString("peran", "GURU");
        muat();
        etCari.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence s,int a,int b,int c){}
            public void onTextChanged(CharSequence s,int a,int b,int c){ filter(s.toString()); }
            public void afterTextChanged(Editable s){}
        });
    }
    @Override protected void onResume(){ super.onResume(); muat(); }
    void muat(){
        semua = new ArrayList<>(pref.getStringSet("santri", new HashSet<>()));
        Collections.sort(semua);
        filter(etCari.getText().toString());
    }
    void filter(String q){
        tampil.clear();
        for(String s: semua){ if(q.isEmpty() || s.toLowerCase().contains(q.toLowerCase())) tampil.add(s); }
        tvTotal.setText("Total " + tampil.size() + " Santri  •  " + semua.size() + " Santri Aktif");
        gambar();
    }
    String ambil(String data, String kunci){
        // data format: Nama: umar\nKelas: 1 | Hafalan: 0 Juz - 0 Halaman\nPentasmi: ... | WA: ...
        try{
            int i = data.indexOf(kunci);
            if(i<0) return "-";
            String sisa = data.substring(i+kunci.length()).trim();
            int end = sisa.indexOf("\n"); if(end>0) sisa = sisa.substring(0,end);
            int pipe = sisa.indexOf(" | "); if(pipe>0) sisa = sisa.substring(0,pipe);
            return sisa.trim();
        }catch(Exception e){ return "-"; }
    }
    void gambar(){
        container.removeAllViews();
        if(tampil.isEmpty()){
            TextView t = new TextView(this);
            t.setText("Belum ada santri.\nTambahkan dari menu Tambah Santri ya.");
            t.setGravity(Gravity.CENTER); t.setPadding(0,80,0,0); t.setTextSize(15);
            container.addView(t); return;
        }
        int no=1;
        for(String data: tampil){
            View v = getLayoutInflater().inflate(R.layout.item_santri, container, false);
            TextView tvAvatar=v.findViewById(R.id.tvAvatar);
            TextView tvNama=v.findViewById(R.id.tvNama);
            TextView tvInfo=v.findViewById(R.id.tvInfo);
            TextView tvBadge=v.findViewById(R.id.tvBadge);
            Button btnDetail=v.findViewById(R.id.btnDetail);
            Button btnHapus=v.findViewById(R.id.btnHapus);
            String nama=ambil(data,"Nama:");
            String kelas=ambil(data,"Kelas:");
            String hafalan=ambil(data,"Hafalan:");
            String wa=ambil(data,"WA:");
            tvAvatar.setText(nama.isEmpty()?"?":nama.substring(0,1).toUpperCase());
            tvNama.setText(no+". "+nama);
            tvInfo.setText("Kelas "+kelas+"  •  "+hafalan+"  •  WA: "+wa);
            tvBadge.setText("KELAS "+kelas);
            btnDetail.setOnClickListener(x->{
                Intent i=new Intent(this, DetailActivity.class);
                i.putExtra("nama",nama); i.putExtra("data",data);
                startActivity(i);
            });
            if(peran.equals("WALI")){ btnHapus.setVisibility(View.GONE); }
            else{
                btnHapus.setOnClickListener(x->{
                    new AlertDialog.Builder(this)
                    .setTitle("Hapus Santri?")
                    .setMessage("Hapus "+nama+" ?\nSantri yang lulus / keluar akan terhapus permanen.")
                    .setPositiveButton("Ya, Hapus",(d,w)->{
                        Set<String> set=new HashSet<>(pref.getStringSet("santri",new HashSet<>()));
                        set.remove(data);
                        pref.edit().putStringSet("santri",set).apply();
                        muat();
                        Toast.makeText(this,"Santri dihapus",Toast.LENGTH_SHORT).show();
                    })
                    .setNegativeButton("Batal",null).show();
                });
            }
            container.addView(v); no++;
        }
    }
}
