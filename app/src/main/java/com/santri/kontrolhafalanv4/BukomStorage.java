package com.santri.kontrolhafalanv4;
import android.content.Context; import android.content.SharedPreferences; import java.util.*;
public class BukomStorage {
    public static final String PREF = "BUKOM";
    public static SharedPreferences pref(Context c){ return c.getSharedPreferences(PREF, Context.MODE_PRIVATE); }
    public static List<String> getSantriRaw(Context c){ List<String> l=new ArrayList<>(pref(c).getStringSet("santri",new HashSet<>())); Collections.sort(l); return l; }
    public static List<Santri> getSantri(Context c){ List<Santri> out=new ArrayList<>(); for(String r:getSantriRaw(c)) out.add(new Santri(r)); return out; }
    public static void addSantriRaw(Context c,String d){ Set<String> s=new HashSet<>(pref(c).getStringSet("santri",new HashSet<>())); s.add(d); pref(c).edit().putStringSet("santri",s).apply(); }
    public static void deleteSantriRaw(Context c,String d){ Set<String> s=new HashSet<>(pref(c).getStringSet("santri",new HashSet<>())); s.remove(d); pref(c).edit().putStringSet("santri",s).apply(); }
    public static List<String> getHafalan(Context c){ List<String> l=new ArrayList<>(pref(c).getStringSet("hafalan",new HashSet<>())); Collections.sort(l); return l; }
    public static void addHafalan(Context c,String d){ Set<String> s=new HashSet<>(pref(c).getStringSet("hafalan",new HashSet<>())); s.add(d); pref(c).edit().putStringSet("hafalan",s).apply(); }
    public static String ambil(String data,String kunci){ try{ int i=data.indexOf(kunci); if(i<0) return "-"; String sisa=data.substring(i+kunci.length()).trim(); int end=sisa.indexOf("\n"); if(end>0) sisa=sisa.substring(0,end); int pipe=sisa.indexOf(" | "); if(pipe>0) sisa=sisa.substring(0,pipe); return sisa.trim(); }catch(Exception e){ return "-"; } }
    public static String peran(Context c){ return pref(c).getString("peran","GURU"); }
    public static boolean isWali(Context c){ return peran(c).equals("WALI"); }
}
