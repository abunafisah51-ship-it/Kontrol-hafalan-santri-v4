package com.santri.kontrolafalanv4;

import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerViewSurah);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<String> surahList = new ArrayList<>();
        String[] daftarSurah = {
            "Al-Fatihah", "Al-Baqarah", "Ali 'Imran", "An-Nisa'", "Al-Ma'idah", 
            "Al-An'am", "Al-A'raf", "Al-Anfal", "At-Taubah", "Yunus", 
            "Hud", "Yusuf", "Ar-Rad", "Ibrahim", "Al-Hijr", "An-Nahl", 
            "Al-Isra'", "Al-Kahf", "Maryam", "Ta-Ha", "Al-Anbiya'", "Al-Hajj", 
            "Al-Mu'minun", "An-Nur", "Al-Furqan", "Ash-Shu'ara", "An-Naml", 
            "Al-Qasas", "Al-Ankabut", "Ar-Rum", "Luqman", "As-Sajdah", 
            "Al-Ahzab", "Saba'", "Fatir", "Ya-Sin", "As-Saffat", "Sad", 
            "Az-Zumar", "Ghafir", "Fussilat", "Ash-Shuraa", "Az-Zukhruf", 
            "Ad-Dukhan", "Al-Jathiyah", "Al-Ahqaf", "Muhammad", "Al-Fath", 
            "Al-Hujurat", "Qaf", "Ad-Dhariyat", "At-Tur", "An-Najm", "Al-Qamar", 
            "Ar-Rahman", "Al-Waqi'ah", "Al-Hadid", "Al-Mujadila", "Al-Hashr", 
            "Al-Mumtahanah", "As-Saff", "Al-Jumu'ah", "Al-Munafiqun", "At-Taghabun", 
            "At-Talaq", "At-Tahrim", "Al-Mulk", "Al-Qalam", "Al-Haqqah", 
            "Al-Ma'arij", "Nuh", "Al-Jinn", "Al-Muzzammil", "Al-Muddaththir", 
            "Al-Qiyamah", "Al-Insan", "Al-Mursalat", "An-Naba'", "An-Nazi'at", 
            "Abasa", "At-Takwir", "Al-Infitar", "Al-Mutaffifin", "Al-Inshiqaq", 
            "Al-Buruj", "At-Tariq", "Al-A'la", "Al-Ghashiyah", "Al-Fajr", 
            "Al-Balad", "Ash-Shams", "Al-Lail", "Ad-Duha", "Ash-Sharh", 
            "At-Tin", "Al-Alaq", "Al-Qadr", "Al-Bayyinah", "Az-Zalzalah", 
            "Al-Adiyat", "Al-Qari'ah", "At-Takathur", "Al-Asr", "Al-Humazah", 
            "Al-Fil", "Quraysh", "Al-Ma'un", "Al-Kauthar", "Al-Kafirun", 
            "An-Nasr", "Al-Masad", "Al-Ikhlas", "Al-Falaq", "An-Nas"
        };

        for (String s : daftarSurah) {
            surahList.add(s);
        }

        SurahAdapter adapter = new SurahAdapter(surahList, position -> {
            Toast.makeText(MainActivity.this, "Memilih: " + surahList.get(position), Toast.LENGTH_SHORT).show();
        });

        recyclerView.setAdapter(adapter);
    }
}
