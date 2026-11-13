package com.santri.kontrolhafalanv4;
import android.content.Context;
import android.content.SharedPreferences;
import java.util.*;
public class BukomStorage {
    public static final String PREF = "BUKOM";
    public static SharedPreferences pref(Context c){ return c.getSharedPreferences(PREF, Context.MODE_PRIVATE); }
    public static List<String> getSantriRaw(Context c){ List<String> l = new ArrayList<>(pref(c).getStringSet("santri", new HashSet<>())); Collections.sort(l); return l; }
    public static void addSantriRaw(Context c, String data){ Set<String> s = new HashSet<>(pref(c).getStringSet("santri", new HashSet<>())); s.add(data); pref(c).edit().putStringSet("santri", s).apply(); }
    public static void deleteSantriRaw(Context c, String data){ Set<String> s = new HashSet<>(pref(c).getStringSet("santri", new HashSet<>())); s.remove(data); pref(c).edit().putStringSet("santri", s).apply(); }
    public static List<String> getHafalan(Context c){ List<String> l = new ArrayList<>(pref(c).getStringSet("hafalan", new HashSet<>())); Collections.sort(l); return l; }
    public static void addHafalan(Context c, String data){ Set<String> s = new HashSet<>(pref(c).getStringSet("hafalan", new HashSet<>())); s.add(data); pref(c).edit().putStringSet("hafalan", s).apply(); }
    public static String ambil(String data, String kunci){ try{ int i = data.indexOf(kunci); if(i<0) return "-"; String sisa = data.substring(i+kunci.length()).trim(); int end = sisa.indexOf("\n"); if(end>0) sisa = sisa.substring(0,end); int pipe = sisa.indexOf(" | "); if(pipe>0) sisa = sisa.substring(0,pipe); return sisa.trim(); }catch(Exception e){ return "-"; } }
    public static String nama(String d){ return ambil(d,"Nama:"); }
    public static String kelas(String d){ return ambil(d,"Kelas:"); }
    public static String hafalan(String d){ return ambil(d,"Hafalan:"); }
    public static String wa(String d){ return ambil(d,"WA:"); }
    public static String peran(Context c){ return pref(c).getString("peran","GURU"); }
    public static boolean isWali(Context c){ return peran(c).equals("WALI"); }
}
