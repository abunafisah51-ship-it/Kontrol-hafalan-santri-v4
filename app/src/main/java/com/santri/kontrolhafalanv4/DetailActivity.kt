package com.santri.kontrolhafalanv4
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
class DetailActivity : AppCompatActivity() {
 override fun onCreate(s: Bundle?) {
  super.onCreate(s)
  setContentView(R.layout.activity_detail)
  val surah = intent.getStringExtra("surah") ?: ""
  findViewById<TextView>(R.id.tvSurah).text = surah
  val prefs = getSharedPreferences("hafalan", MODE_PRIVATE)
  val etNama = findViewById<EditText>(R.id.etNama)
  val etCatatan = findViewById<EditText>(R.id.etCatatan)
  val cb = findViewById<CheckBox>(R.id.cbHafal)
  etNama.setText(prefs.getString(surah+"_nama",""))
  etCatatan.setText(prefs.getString(surah+"_catatan",""))
  cb.isChecked = prefs.getBoolean(surah+"_hafal", false)
  findViewById<Button>(R.id.btnSimpan).setOnClickListener {
   prefs.edit().putString(surah+"_nama", etNama.text.toString()).putString(surah+"_catatan", etCatatan.text.toString()).putBoolean(surah+"_hafal", cb.isChecked).apply()
   Toast.makeText(this, "Tersimpan", Toast.LENGTH_SHORT).show()
   finish()
  }
 }
}
