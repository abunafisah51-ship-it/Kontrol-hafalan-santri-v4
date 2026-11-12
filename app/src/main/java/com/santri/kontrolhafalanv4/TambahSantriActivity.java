package com.santri.kontrolhafalanv4;

import android.os.Bundle;
import android.widget.*;
import android.view.Gravity;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import java.util.*;

public class TambahSantriActivity extends AppCompatActivity {
    protected void onCreate(Bundle b){
        super.onCreate(b);
        UiHelper.setup(this);
        LinearLayout lay = UiHelper.page(this, "TAMBAH SANTRI", "Santri baru langsung online ke semua HP");
        ScrollView sv = new ScrollView(this);
        LinearLayout isi = new LinearLayout(this);
        isi.setOrientation(LinearLayout.VERTICAL);
        isi.setPadding(32,28,32,28);

        LinearLayout card = UiHelper.card(this);
        card.addView(UiHelper.label(this, "Nama Santri Baru"));
        EditText e = UiHelper.input(this, "Contoh: Umar");
        card.addView(e);
        isi.addView(card);

        LinearLayout card2 = UiHelper.card(this);
        card2.addView(UiHelper.label(this, "Kelas Santri"));
        Spinner spKelas = new Spinner(this);
        String[] listKelas = new String[]{"Kelas 1","Kelas 2","Kelas 3","Kelas 4","Kelas 5","Kelas 6"};
        ArrayAdapter<String> ad = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, listKelas);
        spKelas.setAdapter(ad);
        card2.addView(spKelas);
        isi.addView(card2);

        Button sm = UiHelper.tombol(this, "Simpan & Kirim Online");
        sm.setOnClickListener(v->{
            String nm = e.getText().toString().trim();
            if(nm.isEmpty()){ Toast.makeText(this,"Isi dulu namanya",Toast.LENGTH_SHORT).show(); return; }
            String kelas = spKelas.getSelectedItem().toString();
            String dataBaru = nm + "|" + kelas;
            String lama = getSharedPreferences("hafalan", MODE_PRIVATE).getString("daftar_santri","Hudzaifah|Kelas 1,Nabil|Kelas 1,Fatan|Kelas 1,Hisyam|Kelas 1,Kenan|Kelas 1");
            String baru = lama.isEmpty() ? dataBaru : lama + "," + dataBaru;
            getSharedPreferences("hafalan", MODE_PRIVATE).edit().putString("daftar_santri", baru).apply();
            FirebaseHelper.simpanOnline("daftar_santri","\""+baru+"\"");
            Toast.makeText(this, nm + " ("+kelas+") tersimpan & terkirim online", Toast.LENGTH_SHORT).show();
            finish();
        });
        isi.addView(sm);
        sv.addView(isi);
        lay.addView(sv);
        setContentView(lay);
    }
}
