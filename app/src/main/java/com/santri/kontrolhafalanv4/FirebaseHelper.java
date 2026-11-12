package com.santri.kontrolhafalanv4;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import android.app.Activity;
public class FirebaseHelper {
 public static String DB = "https://kontrol-hafalan-default-rtdb.asia-southeast1.firebasedatabase.app";
 public static void simpanOnline(String path, String json){
  new Thread(() -> { try{
   URL u = new URL(DB+"/"+path+".json");
   HttpURLConnection c = (HttpURLConnection) u.openConnection();
   c.setRequestMethod("PUT"); c.setDoOutput(true);
   c.setRequestProperty("Content-Type","application/json");
   OutputStream os = c.getOutputStream(); os.write(json.getBytes("UTF-8")); os.close();
   c.getResponseCode(); c.disconnect();
  }catch(Exception e){} }).start();
 }
 public static void loadOnline(Activity act){
  new Thread(() -> { try{
   URL u = new URL(DB+"/daftar_santri.json");
   HttpURLConnection c = (HttpURLConnection) u.openConnection();
   c.setRequestMethod("GET");
   Scanner s = new Scanner(c.getInputStream()).useDelimiter("\\A");
   String r = s.hasNext()? s.next():""; c.disconnect();
   if(r!=null && r.length()>3 && !r.equals("null")){
    String bersih = r.replace("\"","");
    String lama = act.getSharedPreferences("hafalan",0).getString("daftar_santri","");
    if(!bersih.equals(lama)){
     act.getSharedPreferences("hafalan",0).edit().putString("daftar_santri",bersih).apply();
     act.runOnUiThread(() -> act.recreate());
    }
   }
  }catch(Exception e){} }).start();
 }
}
