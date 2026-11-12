package com.santri.kontrolhafalanv4;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class PendahuluanActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_pendahuluan);
        Button btnLanjut = findViewById(R.id.btnLanjut);
        if (btnLanjut != null) {
            btnLanjut.setOnClickListener(v -> {
                startActivity(new Intent(this, MainActivity.class));
                finish();
            });
        }
    }
}
