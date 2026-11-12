package com.santri.kontrolhafalanv4;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
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
}
