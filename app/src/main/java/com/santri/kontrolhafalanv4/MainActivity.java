package com.santri.kontrolhafalanv4;
import android.os.Bundle;
import android.app.AlertDialog; import android.content.Intent; import android.graphics.*; import android.widget.*;
import androidx.appcompat.app.AppCompatActivity; import java.util.*;
public class MainActivity extends AppCompatActivity {
 protected void onCreate(Bundle b){ super.onCreate(b); UiHelper.setup(this);
  LinearLayout lay=UiHelper.page(this,"KONTROL HAFALAN SANTRI","Pondok Pesantren  •  Program 30 Juz  •  Online");
  ScrollView sv=new ScrollView(this); LinearLayout isi=new LinearLayout(this); isi.setOrientation(LinearLayout.VERTICAL); isi.setPadding(32,28,32,28);
  LinearLayout banner=UiHelper.card(this); banner.setBackgroundColor(UiHelper.HIJAU_MUDA);
  TextView bt=UiHelper.title(this,"Target Hari Ini"); banner.addView(bt);
  TextView bd=new TextView(this); bd.setText("Hafalan Baru  •  3 Bagian\nMurojaah  •  2 Halaman"); bd.setTextSize(14); bd.setTypeface(Typeface.SANS_SERIF); bd.setTextColor(UiHelper.TEKS); bd.setPadding(0,8,0,0); banner.addView(bd); isi.addView(banner);
  isi.addView(UiHelper.section(this,"MENU UTAMA"));
  FirebaseHelper.loadOnline(this);
  String[][] menu={{"📋","Daftar Santri","Lihat, kelola & hapus santri"},{"📖","Hafalan Baru","Input 3 bagian / hari"},{"🔄","Murojaah","Input 2 halaman / hari"},{"📊","Progres 30 Juz","Pantau progres tiap santri"},{"📄","Laporan Wali","Rekap untuk wali santri"},{"📈","Dashboard Pengajar","Rekap harian pengajar"},{"➕","Tambah Santri","Tambah santri baru"}};
  for(int i=0;i<menu.length;i++){ int pos=i; LinearLayout card=UiHelper.card(this); card.setOrientation(LinearLayout.HORIZONTAL);
   TextView ic=new TextView(this); ic.setText(menu[i][0]); ic.setTextSize(26); ic.setPadding(0,0,28,0); card.addView(ic);
   LinearLayout tx=new LinearLayout(this); tx.setOrientation(LinearLayout.VERTICAL); tx.setLayoutParams(new LinearLayout.LayoutParams(0,-2,1));
   tx.addView(UiHelper.title(this,menu[i][1])); tx.addView(UiHelper.desc(this,menu[i][2])); card.addView(tx);
   TextView panah=new TextView(this); panah.setText("›"); panah.setTextSize(28); panah.setTypeface(Typeface.DEFAULT_BOLD); panah.setTextColor(UiHelper.EMAS); card.addView(panah);
   card.setOnClickListener(v->{ Class c=DetailActivity.class; if(pos==1)c=HafalanActivity.class; else if(pos==2)c=MurojaahActivity.class; else if(pos==3)c=ProgressActivity.class; else if(pos==4)c=WaliActivity.class; else if(pos==5)c=DashboardActivity.class; else if(pos==6)c=TambahSantriActivity.class; Intent in=new Intent(this,c); if(pos==0){ String daftar=getSharedPreferences("hafalan",MODE_PRIVATE).getString("daftar_santri","Hudzaifah,Nabil,Fatan,Hisyam,Kenan"); in.putExtra("surah_name","Daftar Santri:\n"+daftar.replace(",","\n")); } startActivity(in); });
   isi.addView(card);
  }
// BUKOM - Sambutan A, Tidak Dibedakan
android.widget.TextView tvSalam = new android.widget.TextView(this);
tvSalam.setText(BUKOMFinal.BISMILLAH + "\n" + BUKOMFinal.SALAM + "\n" + BUKOMFinal.JUDUL + "\n" + BUKOMFinal.SUBJUDUL + "\n\n" + BUKOMFinal.HADITS);
tvSalam.setTextSize(13); tvSalam.setGravity(android.view.Gravity.CENTER); tvSalam.setPadding(0,16,0,8);
tvSalam.setTextColor(UiHelper.EMAS);
isi.addView(tvSalam);
android.widget.TextView tvTujuan = new android.widget.TextView(this);
tvTujuan.setText(BUKOMFinal.TUJUAN);
tvTujuan.setTextSize(12); tvTujuan.setPadding(12,12,12,12);
isi.addView(tvTujuan);
android.widget.TextView tvLogin = new android.widget.TextView(this);
tvLogin.setText(BUKOMFinal.LOGIN_TEXT);
tvLogin.setTextSize(13); tvLogin.setGravity(android.view.Gravity.CENTER); tvLogin.setPadding(0,8,0,16);
tvLogin.setTypeface(android.graphics.Typeface.DEFAULT_BOLD);
isi.addView(tvLogin);
// Akhir Sambutan
android.widget.TextView tvKelas = new android.widget.TextView(this);
tvKelas.setText("3. KELAS & TARGET\n" + BUKOMFinal.KELAS_1 + " : " + BUKOMFinal.TARGET_KELAS_1_JUZ + " Juz\n" + BUKOMFinal.KELAS_2 + " : " + BUKOMFinal.TARGET_KELAS_2_JUZ + " Juz\n" + BUKOMFinal.KELAS_3 + " : " + BUKOMFinal.TARGET_KELAS_3_JUZ + " Juz\nTarget Akhir : " + BUKOMFinal.TARGET_AKHIR_JUZ + " Juz");
tvKelas.setTextSize(12); tvKelas.setPadding(12,12,12,12);
isi.addView(tvKelas);
android.widget.TextView tvMax = new android.widget.TextView(this);
tvMax.setText("4. MAX 6 ANAK\n" + BUKOMFinal.ATURAN_MAX + "\nMax: " + BUKOMFinal.MAX_ANAK_PER_PENTASMI + " santri");
tvMax.setTextSize(12); tvMax.setPadding(12,12,12,12);
isi.addView(tvMax);
android.widget.TextView tvPindah = new android.widget.TextView(this);
tvPindah.setText("5. " + BUKOMFinal.JUDUL_PINDAH + "\n" + BUKOMFinal.KETERANGAN_PINDAH + "\nMax " + BUKOMFinal.MAX_HARI_PINDAH + " hari");
tvPindah.setTextSize(12); tvPindah.setPadding(12,12,12,12);
isi.addView(tvPindah);
android.widget.TextView tvLaporan = new android.widget.TextView(this);
tvLaporan.setText("7. " + BUKOMFinal.LAPORAN_JUDUL + "\n" + BUKOMFinal.LAPORAN_VIA + "\n" + BUKOMFinal.FORMAT_LAPORAN);
tvLaporan.setTextSize(12); tvLaporan.setPadding(12,12,12,12);
isi.addView(tvLaporan);
  TextView foot=new TextView(this); foot.setText("Versi 5.0  •  Online  •  Data tersimpan di Firebase"); foot.setTextSize(11); foot.setTypeface(Typeface.SANS_SERIF); foot.setTextColor(UiHelper.ABU); foot.setGravity(android.view.Gravity.CENTER); foot.setPadding(0,10,0,0); isi.addView(foot);
  sv.addView(isi); lay.addView(sv); setContentView(lay);
 }
}
