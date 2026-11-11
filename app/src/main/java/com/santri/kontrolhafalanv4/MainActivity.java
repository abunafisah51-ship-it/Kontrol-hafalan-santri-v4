package com.santri.kontrolhafalanv4;
import com.santri.kontrolhafalanv4.R;

import android.os.Bundle;
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

        RecyclerView recyclerViewSurah = findViewById(R.id.recyclerViewSurah);
        if (recyclerViewSurah != null) {
            recyclerViewSurah.setLayoutManager(new LinearLayoutManager(this));

            List<String> surahList = new ArrayList<>();
            surahList.add("Al-Fatihah");
            surahList.add("Al-Baqarah");

            SurahAdapter adapter = new SurahAdapter(surahList, position -> {
                // Aksi klik surah
            });
            recyclerViewSurah.setAdapter(adapter);
        }
    }
}
