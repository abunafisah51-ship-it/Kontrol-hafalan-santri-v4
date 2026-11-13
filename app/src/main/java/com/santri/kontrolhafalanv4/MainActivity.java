package com.santri.kontrolhafalanv4;
import android.os.Bundle; import android.content.Intent; import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity { protected void onCreate(Bundle b){ super.onCreate(b); startActivity(new Intent(this, DashboardActivity.class)); finish(); } }
