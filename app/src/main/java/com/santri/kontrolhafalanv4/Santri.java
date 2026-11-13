package com.santri.kontrolhafalanv4;
public class Santri {
    public String nama, kelas, hafalan, pentasmi, wa, raw;
    public Santri(String raw){ this.raw=raw; this.nama=BukomStorage.ambil(raw,"Nama:"); this.kelas=BukomStorage.ambil(raw,"Kelas:"); this.hafalan=BukomStorage.ambil(raw,"Hafalan:"); this.pentasmi=BukomStorage.ambil(raw,"Pentasmi:"); this.wa=BukomStorage.ambil(raw,"WA:"); }
    public String inisial(){ return nama.isEmpty()?"?":nama.substring(0,1).toUpperCase(); }
    public String label(){ return nama+" - Kelas "+kelas; }
    public String toData(){ return "Nama: "+nama+" | Kelas: "+kelas+" | Hafalan: "+hafalan+" | WA: "+wa; }
}
