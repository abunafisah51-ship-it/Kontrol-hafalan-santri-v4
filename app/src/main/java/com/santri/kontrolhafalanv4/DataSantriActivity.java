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
import com.google.firebase.database.*;
import java.util.*;

public class DataSantriActivity extends AppCompatActivity {
    LinearLayout container;
    EditText etCari;
    TextView tvTotal;
    List<Map<String,String>> semua = new ArrayList<>();
    List<Map<String,String>> tampil = new ArrayList<>();
    String peran = "GURU";
    DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_santri);
        container = findViewById(R.id.containerSantri);
        etCari = findViewById(R.id.etCari);
        tvTotal = findViewById(R.id.tvTotal);
        peran = getSharedPreferences("BUKOM", MODE_PRIVATE).getString("peran", "GURU");

        ref = FirebaseDatabase.getInstance().getReference("santri");
        ref.addValueEventListener(new ValueEventListener() {
            public void onDataChange(DataSnapshot s) {
                semua.clear();
                for (DataSnapshot d : s.getChildren()) {
                    Map<String,String> m = new HashMap<>();
                    m.put("key", d.getKey());
                    m.put("nama", String.valueOf(d.child("nama").getValue() == null ? d.getKey() : d.child("nama").getValue()));
                    m.put("kelas", String.valueOf(d.child("kelas").getValue() == null ? "1" : d.child("kelas").getValue()));
                    m.put("juz", String.valueOf(d.child("juz").getValue() == null ? "0" : d.child("juz").getValue()));
                    semua.add(m);
                }
                filter(etCari.getText().toString());
            }
            public void onCancelled(DatabaseError e) {}
        });

        etCari.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence s,int a,int b,int c){}
            public void onTextChanged(CharSequence s,int a,int b,int c){ filter(s.toString()); }
            public void afterTextChanged(Editable s){}
        });
    }

    void filter(String q) {
        tampil.clear();
        for (Map<String,String> m : semua) {
            if (q.isEmpty() || m.get("nama").toLowerCase().contains(q.toLowerCase())) tampil.add(m);
        }
        tvTotal.setText("Total " + tampil.size() + " Santri  •  " + semua.size() + " Santri Aktif");
        gambar();
    }

    void gambar() {
        container.removeAllViews();
        if (tampil.isEmpty()) {
            TextView t = new TextView(this);
            t.setText("Belum ada santri.\nTambahkan dari menu Tambah Santri ya.");
            t.setGravity(Gravity.CENTER); t.setPadding(0,80,0,0); t.setTextSize(15);
            container.addView(t); return;
        }
        int no = 1;
        for (Map<String,String> m : tampil) {
            View v = getLayoutInflater().inflate(R.layout.item_santri, container, false);
            TextView tvAvatar = v.findViewById(R.id.tvAvatar);
            TextView tvNama = v.findViewById(R.id.tvNama);
            TextView tvInfo = v.findViewById(R.id.tvInfo);
            TextView tvBadge = v.findViewById(R.id.tvBadge);
            Button btnDetail = v.findViewById(R.id.btnDetail);
            Button btnHapus = v.findViewById(R.id.btnHapus);

            String nama = m.get("nama");
            tvAvatar.setText(nama.substring(0,1).toUpperCase());
            tvNama.setText(no + ". " + nama);
            tvInfo.setText("Kelas " + m.get("kelas") + "  •  " + m.get("juz") + " Juz  •  Target 3 paragraf / hari");
            tvBadge.setText("KELAS " + m.get("kelas"));

            btnDetail.setOnClickListener(x -> {
                Intent i = new Intent(this, DetailActivity.class);
                i.putExtra("nama", nama); i.putExtra("key", m.get("key"));
                startActivity(i);
            });

            if (peran.equals("WALI")) { btnHapus.setVisibility(View.GONE); }
            else {
                btnHapus.setOnClickListener(x -> {
                    new AlertDialog.Builder(this)
                        .setTitle("Hapus Santri?")
                        .setMessage("Hapus " + nama + " ?\nSantri yang lulus / keluar akan terhapus permanen.")
                        .setPositiveButton("Ya, Hapus", (d,w) -> ref.child(m.get("key")).removeValue())
                        .setNegativeButton("Batal", null).show();
                });
            }
            container.addView(v);
            no++;
        }
    }
}
