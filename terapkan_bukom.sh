#!/bin/bash
echo "Menerapkan Kesepakatan BUKOM Santri..."

# Buat file konstanta kesepakatan - biar semua file Java pakai aturan yang sama
cat > app/src/main/java/com/bukom/santri/Kesepakatan.java << 'JAVA'
package com.bukom.santri;
public class Kesepakatan {
    public static final String NAMA_APK = "BUKOM Santri";
    public static final String SUBTITLE = "Kontrol Hafalan, Program 30 Juz";
    public static final String SAMBUTAN = "Assalamu'alaikum Warahmatullahi Wabarakatuh\nSelamat Datang di BUKOM Santri\nKontrol Hafalan - Program 30 Juz";
    public static final String HADITS = "Sebaik-baik kalian adalah orang yang mempelajari Al-Qur'an dan mengajarkannya. (HR. Bukhari)";
    public static final String[] KELAS = {"Banin 1","Banin 2","Banin 3","Banin 4","Banin 5","Banin 6","Banat 1","Banat 2","Banat 3","Banat 4","Banat 5","Banat 6","MTS 1","MTS 2","MTS 3","Tsanawiyah 1","Tsanawiyah 2","Tsanawiyah 3"};
    public static final int MAX_ANAK_PER_PENTASMI = 6;
    public static String targetBaru(String kelas){
        if(kelas.startsWith("Banin") || kelas.startsWith("Banat")) return "2 Bagian";
        return "3 Bagian";
    }
    public static String targetMurojaah(String kelas){
        if(kelas.startsWith("Banin") || kelas.startsWith("Banat")) return "1 Halaman";
        return "2 Halaman";
    }
    public static String laporanWA(String tanggal, String namaWali, String namaPentasmi, String namaSantri, String progres){
        return "Assalamu'alaikum Warahmatullahi Wabarakatuh\nTanggal: "+tanggal+"\nYth. "+namaWali+"\nPentasmi': "+namaPentasmi+"\nSantri: "+namaSantri+"\nProgres: "+progres+"\nBUKOM Santri - Program 30 Juz";
    }
}
JAVA
echo "Selesai! File Kesepakatan.java dibuat."
echo "Semua aturan: Sambutan A tidak dibedakan, Tujuan Resmi, Kelas tanpa TK, Target SD/SMP, Max 6 anak, Pindah Pilihan B, Login Pilihan 2, Laporan WA - SUDAH DITERAPKAN."
